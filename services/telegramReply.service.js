const { default: axios } = require("axios");
const { telegramBotApiUrl, telegramBotToken } = require("../env");

const telegramApiService = axios.create({
  baseURL: `${telegramBotApiUrl}/bot${telegramBotToken}`,
});

module.exports.sendMessageToUser = async (chatId, msg) => {
  try {
    await telegramApiService.post("/sendMessage", {
      chat_id: chatId,
      text: msg,
    });
  } catch (error) {
    console.log(error);
  }
};
