# MM4 Client library
MM4 client libreary for a testing purpose

## How to use it
### 1. Download a jar lib
Download [mm4-client.jar](https://github.com/peterjurkovic/smtp/raw/master/mm4-client.jar)

### 2. Run the command

```
mm4-client.jar -jar 
```

By default it sends **MM4_FORWARD_REQ** containing an image. In order to change the type just pass an additional parameter

```
mm4-client.jar -Dport=25 -jar MM4_FORWARD_RES 
```
Please note: every `-Dxxx` parameter must be placed before `-jar` flag
### 3. Verbose mode
If you want to print out entire message pass `-Dverbose` parameter as following

```
mm4-client.jar -Dverbose -jar MM4_FORWARD_RES 
```

## Default values

| Header                    | Default value   | Override           |
|---------------------------|-----------------|--------------------|
| host                      | localhost       | -Dhost=custom-host |
| port                      | 4115            | -Dport=25          |
| from                      | from@test.tld   | -Dfrom=custom      |
| to                        | to@test.tld     | -Dto=custom        |
| X-Mms-Message-Type        | MM4_FORWARD_REQ | -Dmessageid=custom |
| X-Mms-3GPP-Version        | 1.0             | -Dversion=custom   |
| X-Mms-Message-ID          | messageId       | -DmessageId        |
| X-Mms-Transaction-ID      | transactionId   | -DtransactionId    |
| X-Mms-MM-Status-Code      | Forwarded       | -DmessageStatus    |
| X-Mms-Request-Status-Code | 0               | -DrequestStatus    |
| X-Mms-Ack-Request         | Yes             | -Dack              |

## Accepted Request types

```
MM4_FORWARD_REQ
MM4_FORWARD_RES
MM4_DELIVERY_REPORT_REQ
MM4_DELIVERY_REPORT_RES
MM4_READ_REPLY_REPORT_REQ
MM4_READ_REPLY_REPORT_RES
```


