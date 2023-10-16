const chromium = require("chrome-aws-lambda");

exports.handler = async (event, context, callback) => {
  let result = null;
  let browser = null;
  const { appCode, appVersion, venueCode, dateCode } =
    event.queryStringParameters;
  console.log(appCode, appVersion, venueCode, dateCode);
  try {
    browser = await chromium.puppeteer.launch({
      args: chromium.args,
      defaultViewport: chromium.defaultViewport,
      executablePath: await chromium.executablePath,
      headless: chromium.headless,
      ignoreHTTPSErrors: true,
    });

    const page = await browser.newPage();

    await page.setUserAgent(
      "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:109.0) Gecko/20100101 Firefox/110.0"
    );

    // "https://in.bookmyshow.com/api/v2/mobile/showtimes/byvenue?appCode=MOBAND2&appVersion=12.0.7&venueCode=CXHY&dateCode=20230905"
    await page.goto(
      `https://in.bookmyshow.com/api/v2/mobile/showtimes/byvenue?appCode=${appCode}&appVersion=${appVersion}&venueCode=${venueCode}&dateCode=${dateCode}`
    );

    const bodyText = await page.evaluate(() => {
      return document.querySelector("body").innerText;
    });

    console.log("Page Content:", bodyText);

    try {
      result = JSON.parse(bodyText);
    } catch (jsonError) {
      console.error("Error parsing JSON:", jsonError);
      throw jsonError; // Rethrow the JSON parsing error
    }
  } catch (error) {
    console.error("Error during execution:", error);
    return callback(error);
  } finally {
    if (browser !== null) {
      await browser.close();
    }
  }

  return callback(null, {
    statusCode: 200,
    body: JSON.stringify(result),
  });
};
