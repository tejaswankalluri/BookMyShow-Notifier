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
  } else if (message === "/venue") {
    await messageVenueList(chatId);
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
async function messageVenueList(chatId) {
  try {
    await sendMessageToUser(
      chatId,
      `
        NotifyMyShow:
        Available venues at HYD are: 

        1. AMB Cinemas: Gachibowli - AMBH

        2. Alankar (Pratap Theatre): Langer House - PTTH

        3. Anjali Movie Max: Secunderabad - ANTT

        4. Aradhana Theatre: Hyderabad - ARTH

        5. Arjun 70MM: Kukatpally - ARJU

        6. Asian CineSquare Multiplex: Uppal - AHMH

        7. Asian Cineplanet Multiplex: Kompally - CPHY

        8. Asian Ganga 4K: Dilsukhnagar - ASGN

        9. Asian Jyothi: RC Puram - ASJY

        10. Asian Lakshmikala Cinepride: Moosapet - ACPM

        11. Asian M Cube Mall: Attapur - AMCA

        12. Asian Mukta A2 Konark: Dilsukhnagar - KDNH

        13. Asian Mukta Cinemas A2: MJR Square, Narapally - MJRM

        14. Asian Mukund Cinema: Medchal - AMCM

        15. Asian Radhika Multiplex: ECIL - ARMH

        16. Asian Sha & Shahensha: Chintal - ACHI

        17. Asian Shiva 4K: Dilsukhnagar - ASSH

        18. Asian Swapna 35mm: Katedan - ASRK

        19. Asian Swapna 70mm: Katedan - ASRS

        20. Asian Tarakarama Cineplex: Kachiguda - TRHY

        21. BR Hitech 70mm: Madhapur - HMHD

        22. BVK Multiplex Vijayalakshmi: LB Nagar - BKMV

        23. Bhujanga 70MM: Jeedimetla - BJNG

        24. Carnival: Ameerpet - ADHY

        25. Cine Town Indra Nagendra: Karmanghat - INKM

        26. Cinepolis: CCPL Mall Malkajgiri, Hyderabad - CPCL

        27. Cinepolis: DSL Virtue Mall Uppal, Hyderabad - ABCS

        28. Cinepolis: Mantra Mall, Attapur - CMMA

        29. Cinepolis: Sudha Cinemas, Hyderabad - STHD

        30. Devi 70MM 4K Laser & Dolby Atmos: RTC X Roads - DVRR

        31. GPR Multiplex: Nizampet, Hyderabad - GPRH

        32. Ganesh 70MM: Shamshabad - GNHB

        33. Gokul 70MM: Erragadda - GOKU

        34. INOX: GSM Mall, Hyderabad - IGMH

        35. INOX: GVK One, Banjara Hills - INHY

        36. INOX: Maheshwari - INMH

        37. Indra Venkataramana Padmavati Cinema: Kachiguda - VRKC

        38. Jyothi Cinema: IDA Bolaram - JOTI

        39. Krishna Cinema: Nagaram (Dammaiguda) - KCNK

        40. Lakshmi Kala Mandir: Alwal - LKMT

        41. Mahalaxmi Complex, Kothapeta: Hyderabad - JTMH

        42. Mallikarjuna 70mm A/C DTS: Kukatpally - MAHM

        43. Megha Theatre: Dilsukhnagar - TGMG

        44. Metro Cinema: Bahadurpura - MCBH

        45. Miraj Cinemas: Balanagar - MRAA

        46. Miraj Cinemas: CineTown, Miyapur - MMCA

        47. Miraj Cinemas: Geeta, Chandanagar - MRGT

        48. Miraj Cinemas: Raghavendra, Hyderabad - MRRG

        49. Miraj Cinemas: Shalini Shivani, Hyderabad - MCSS

        50. Mukta A2 Cinemas, Laxmi: Shamshabad - AMCS

        51. Mukta A2 Cinemas, Ramakrishna: Abids - MUAA

        52. Nartaki Theatre: Alwal - NTAH

        53. PVR Forum Sujana Mall: Kukatpally, Hyderabad - PVSF

        54. PVR ICON: Hitech, Madhapur, Hyderabad - PIHM

        55. PVR: 4DX, Forum Sujana Mall Kukatpally, Hyderabad - PFRM

        56. PVR: 4DX, Irrum Manzil, Hyderabad - PVID

        57. PVR: Atrium Gachibowli, Hyderabad - PVAT

        58. PVR: Central Mall, Panjagutta - PVHY

        59. PVR: Inorbit, Cyberabad - CXCB

        60. PVR: Irrum Manzil, Hyderabad - PVIR

        61. PVR: Mallapur, Hyderabad - SMSE

        62. PVR: Musarambagh, Hyderabad - PVMU

        63. PVR: Next Galleria Mall, Panjagutta - PNGM

        64. PVR: Preston Prime, Gachibowli Hyderabad - PVPS

        65. PVR: RK Cineplex, Hyderabad - CXHY

        66. Platinum Movietime: Gachibowli - MTHY

        67. Prasads: Hyderabad - PRHN

        68. Prasads: Large Screen - PRHY

        69. Prashant Cinema: Secunderabad (Newly Renovated) - PRCS
    `
    );

    return await sendMessageToUser(
      chatId,
      `
        70. Priya Theatre: Malleypally - PTHM

        71. Raj Lakshmi Theatre: Uppal - ASRJ

        72. Ranga Theatre 70MM: Jeedimetla - RTHY

        73. SV Cinesquare: Patancheru - PRNC

        74. SVR's Siva Sakthi Theatre: Kapra - SVST

        75. Sai Ranga: Miyapur - SRCM

        76. Sandhya 35mm: RTC X Road - SNDY

        77. Sandhya 70MM 4K Dolby Atmos: RTC X Roads - SMMR

        78. Santosh Cinemas: Abids - SSET

        79. Santosh Theatre: Ibrahimpatnam - SNIB

        80. Sapna Cinemas: Abids - SAPN

        81. Saptagiri 70MM 4K & Dolby Digital: RTC X Roads - SART

        82. Shanti Theatre: Narayanaguda - SHHY

        83. Sharada 70mm: Kapra - SHRD

        84. Sree Ramana 70MM 4K: Amberpet - SRCA

        85. Sree Ramana Gold 4K & Dolby 7.1: Amberpet - SRCH

        86. Sree Ramulu 70mm: Moosapet - SRMO

        87. Sree Sai Puja: Suraram - SPJA

        88. Sree Sai Raja Theatre: Musheerabad - SSRJ

        89. Sri Krishna 70MM: Uppal - SRKR

        90. Sri Sai Ram 70mm A/C 4k Dolby Atmos: Malkajgiri - SSRM

        91. Srinivasa Talkies: Uppal - SRNU

        92. Sudarshan 35MM 4k Laser & Dolby Atmos: RTC X Roads - SUDA

        93. Super Cinema: Balapur - SPCB

        94. Sushma Cinema: Vanasthalipuram - SCVM

        95. Talluri Theatres: Kushaiguda - TLUR

        96. Tivoli Cinemas: Secunderabad - TVHY

        97. VLS Sridevi 2K A/C Dts: Chilakalguda - SCHC

        98. Vijetha 70MM 4k Atmos: Borabanda - VTRB

        99. Vimal 70mm: Balanagar - VLHB

        100. Viswanath 70MM Theatre: Kukatpally - VSWA

        101. Vyjayanthi Cinema A/C 2K: Nacharam - VAJA

        102. Yadagiri Theatre: Santosh Nagar - YDSN
    `
    );
  } catch (error) {
    console.log(error);
  }
}
