"use strict";

const { receiveMessage } = require("./handlers/message.handler");
const { remainderJob, dailyCleanup } = require("./services/bms.service");

module.exports.hello = async (event) => {
  console.log(event.body);
  console.log(event);
  return {
    statusCode: 200,
    body: JSON.stringify(
      {
        message: "Go Serverless v1.0! Your function executed successfully!",
        input: event,
      },
      null,
      2
    ),
  };
};
module.exports.webhook = async (event) => {
  return receiveMessage(event);
};

module.exports.cronToremainder = async (_event) => {
  return remainderJob();
};

module.exports.dailyCleanUpCron = async (_event) => {
  return dailyCleanup();
};
