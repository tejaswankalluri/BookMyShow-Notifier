const moment = require("moment");
const { sendMessageToUser } = require("../services/telegramReply.service");
const prisma = require("../services/prisma.service");

module.exports.receiveMessage = async (event) => {
  const body = JSON.parse(event.body);
  if (!body)
    return {
      statusCode: 200,
    };
  const message = body.message.text;
  const chatId = body.message.chat.id;

  // trigger functions based on messages
  if (message.startsWith("/enroll")) {
    await registerUserWithMovieCode(message, chatId);
  } else if (message === "/wl") {
    await getUserWaitingList(chatId);
  } else if (message === "/start") {
    await messageStart(chatId);
  }

  return {
    statusCode: 200,
  };
};

/**
 * Checks:
 * - check message valid /reg MOVIECODE VENUECODE DATE
 * - check if date is valid(dd-mm-yyyy)
 */
async function registerUserWithMovieCode(msg, chatId) {
  try {
    const data = msg.split(" ");

    if (data.length !== 4)
      return await sendMessageToUser(
        chatId,
        "Invalid Input. input should be /reg MOVIECODE VENUECODE DATE"
      );
    if (!data[1].startsWith("ET"))
      return await sendMessageToUser(
        chatId,
        "Invalid Movie code. input should be /reg MOVIECODE VENUECODE DATE"
      );
    if (data[2].length !== 4)
      return await sendMessageToUser(
        chatId,
        "Invalid Venue code. input should be /reg MOVIECODE VENUECODE DATE"
      );

    // check input date should be only 7 days from now
    if (
      !moment(data[3], "DD-MM-YYYY").isBetween(
        moment(),
        moment().add(7, "days")
      )
    )
      return await sendMessageToUser(
        chatId,
        "Invalid date. date should be a week from now. format(DD-MM-YYYY)"
      );

    //  check if already stored
    const isExist = await prisma.request.findFirst({
      where: {
        chatId,
        date: moment(data[3], "DD-MM-YYYY").toISOString(),
        movieCode: data[1],
        venueCode: data[2],
      },
    });
    if (isExist) return await sendMessageToUser(chatId, "Already Exist");

    // store data in db
    await prisma.request.create({
      data: {
        chatId,
        date: moment(data[3], "DD-MM-YYYY").toISOString(),
        movieCode: data[1],
        venueCode: data[2],
      },
    });
    await sendMessageToUser(chatId, "Registerd movie");
  } catch (error) {
    console.log(error);
    return;
  }
}
/**
 */
async function getUserWaitingList(chatId) {
  try {
    const res = await prisma.request.findMany({
      select: {
        movieCode: true,
        venueCode: true,
        date: true,
      },
      where: {
        chatId,
      },
    });
    await sendMessageToUser(chatId, JSON.stringify(res, null, 2));
  } catch (error) {
    console.log(error);
    return;
  }
}

async function messageStart(chatId) {
  try {
    return await sendMessageToUser(
      chatId,
      `
    Available commands are:

    /wl - Get your waiting list

    /enroll <movie_code> <venue_code> <date_string> - Enroll for notification for given movie at given venue on given date

    - Example Usage: /enroll ET00310790 PVKC 22-04-2021

    - Date string should be in DD-MM-YYYY format

    - Movie Code is present in the URL of the movie's page on in.bookmyshow.com. 

    - Sample URL with movie code at end: https://in.bookmyshow.com/kochi/movies/spider-man-no-way-home/ET00310790
    `
    );
  } catch (error) {
    console.log(error);
  }
}
