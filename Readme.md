# Brief REST & AWS example

./gradlew clean build
./gradlew bootRun

# Features
# - Listen SQS Queue
# - Store Employee Objects in S3

NOTES:
- REST exposed on 8090 port
- Using on memory database
- You need to configure the following resources on your AWS Console (or just customize amazonProperties inside application.yml file):
  - Create a S3 bucket: globant-training-disney-created-from-cli
  - Create a SQS queue: globant-training-disney-queue
- For aws connection purposes I used the credentials stored locally in AWS CLI (aws configure)
