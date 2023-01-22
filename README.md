# Notification-center
Notification-center that handle send notifications (SMS,FCM,Email)
## contents
- [Installation](#installation)
- [Usage](#usage)
- [APIs](#apis)
- [Scenario](#scenario)
- [explanation](#explanation)



## Installation
1 - clone the repo <br />
2 - Make sure you have `Maven` installed. Execute the following maven command from the directory of the project (notification,notificaitonCMD)
that will build jar files that docker file will use them for building image of it
```
mvn clean install
```
3 - then run `docker-compose up`
## Usage
after the docker compose starts make sure you see on the console
then you can send to `localhost:8084`

## APIs

- `GET    /users`
- `POST   /users`
- `DELETE /users`
- `GET    /notification/notifications`
- `POST   /notification/send`
## Scenario
- send notification to a user or set of users
- the notifications have multi types `SMS, Email, PushNotification`
- the number of notifications per minute is limited (SMS,Email)

  So the flow will be

- hit `GET /users` just to check users in DB
- hit `POST /users` to create a dummy user or multi users
- hit `GET /users` again check users in DB
- hit `GET notification/notifications` check notifications in DB
- hit `POST /notification/send` to send a notification

Create User Request Example
```json
{
    "name": "Muhamedkhaled",
    "email": "Muhamedkhaled@test.com"
}
```
Create User Response
```
User has been added successfully
```
there is no need to go throw these properties since its just for demo porposes

Send Notification Request Example
```json
{
    "kind": "TP",
    "providers": [
        "sms",
        "fcm",
        "email"
    ],
    "title": "New Notification",
    "body": "Notification body",
    "consumers": [
        "1","2","3"
    ]
}
```
Send Notification Response
```
Notification has been added successfully
```
| property  	| type   	| values             	| explanation                                                                                                                                                                                                                      	|
|-----------	|--------	|--------------------	|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------	|
| kind      	| String 	| IN, TP             	| IN: if we need to send the notification to a specific user, TP: if we need to send the notification to group of users                                                                                                           	|
| providers 	| Array  	| SMS, EMAIL, FCM 	  | which provider we need to use to send the notification                                                                                                                                                                           	|
| title     	| String 	| Empty              	| notification title                                                                                                                                                                                                               	|
| body      	| String 	| Empty              	| notification body                                                                                                                                                                                                                	|
| consumers 	| Array  	| Empty              	| if the kind is "IN" then this is array of user ids that we need to send the notification to, if the kind is "TP" then this is array of group names or topics that we need to send the notification to all users into these groups |

you can see it in the console it will log everything

## Explanation
![notifications-center](https://github.com/MuhamedKhaled/notification-center/blob/master/projects-arch.png "project flowchart")

1 - when we send a request to notification service which responsable for saving the data into mysql database (users, notifications) then notify any third party services like (notificationCMD)

2 - when the notification send a notifier it uses RabbitMQ to notify notificationcmd that there is a new notification that needs to be sent along with the notification id

3 - Notificationcmd receive the notification and start proccessing
    - select the notification from DB
    - based on type create a new MessageTypeClass and pass the notification
    - then into the MessageTypeClass we set the message
    - load all message providers
    - publish to them the message
    - every Provider split the consumer array into chunks based on (max-per-time) config whitch in out case Assumed max is 100 per 1 min
    - send the notification


