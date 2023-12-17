const moment = require("moment");
const prisma = require("./prisma.service");
const { default: axios } = require("axios");
const { sendMessageToUser } = require("./telegramReply.service");

module.exports.remainderJob = async () => {
  try {
    const data = await prisma.request.findMany({});
    await Promise.all(
      data.map(async (item) => {
        const res = await checkBooking(
          item.movieCode,
          item.venueCode,
          item.date
        );
        console.log(res);
        if (res) {
          await sendMessageToUser(
            item.chatId,
            `movie tickets started ${item.movieCode} ${item.venueCode} ${item.date}`
          );
          await prisma.request.delete({
            where: {
              id: item.id,
            },
          });
        }
      })
    );
    console.log("cron ran", moment().toISOString());
  } catch (error) {
    console.log(error);
  }
};

module.exports.dailyCleanup = async () => {
  try {
    const yesterday = moment().subtract(1, "days").format("YYYY-MM-DD");

    const itemsToDelete = await prisma.request.findMany({
      where: {
        date: yesterday,
      },
    });

    for (const item of itemsToDelete) {
      await prisma.request.delete({
        where: {
          id: item.id,
        },
      });
    }

    return "Cleanup successful";
  } catch (error) {
    console.error("Cleanup error:", error);
    throw error;
  }
};

async function checkBooking(movieCode, venueCode, date) {
  const formatedDate = moment(date).utc().format("YYYYMMDD");
  try {
    const { data } = await axios.get(
      `https://737lz1bq1l.execute-api.ap-south-1.amazonaws.com/default/puppeter`,
      {
        params: {
          appCode: "MOBAND2",
          appVersion: "12.0.7",
          venueCode,
          dateCode: formatedDate,
        },
      }
    );
    for (const item of data.ShowDetails[0].Event) {
      if (item.ChildEvents[0].EventCode === movieCode) {
        return true; // This will exit the function with a true value.
      }
    }
    return false;
  } catch (error) {
    console.log(error);
    return false;
  }
}
