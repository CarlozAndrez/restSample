# Brief REST & AWS example

./gradlew clean build
./gradlew bootRun

# Features
# - Listen SQS Queue
# - Store Employee Objects in S3

NOTES:
- REST exposed on 8090 port
- Using on memory database
- You need to configure the following resources on your AWS Console and customize amazonProperties inside application.yml file:
  - Create a S3 bucket
  - Create a SQS queue
- For aws connection purposes I used the credentials stored locally in AWS CLI (aws configure)
