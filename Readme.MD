# BookMyShow-Notifier

BookMyShow Notifier is a Telegram Bot helps users to get notified when movie tickets are listed.

![Main screen](https://raw.githubusercontent.com/tejaswankalluri/BookMyShow-Notifier/main/docs/screen.png)

link to telgram bot [@notifymyshowbot](https://t.me/notifymyshowbot)

## Technology

- Node js serverless
- AWS lamda
- serverless-puppeter
- Telegram Bot Api

## Strucutre

- This project is divide in two parts api-server, and puppeter for webscraping.

## Installation

- create bot using botFather [@BotFather](https://t.me/BotFather)
- set bottoken at env.js
- create .env
  - DATABASE_URL="mongodb+srv://USERNAME:PASSWORD@URL/DBNAME?retryWrites=true&w=majority"
- ```bash
    npm i -g yarn
  ```
- ```bash
  yarn install
  ```
- ```bash
    npm run dev
  ```

### Deploy

- Create a aws account, and create a AMI user
- Install serverless global
  - ```bash
      npm run dev
    ```
- Connect AMI User to serverless
  - ```bash
      serverless config credentials \
      --provider aws \
      --key 1234 \
      --secret 5678 \
      --profile aws-profile
    ```
