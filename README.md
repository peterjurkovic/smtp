# MM4 Client library

## Defaults

|           Header          |  Default value  |      Override      |
|:-------------------------:|:---------------:|:------------------:|
| host                      | localhost       | -Dhost=custom-host |
| port                      | 4115            | -Dport=25          |
| from                      | from@test.tld   | -Dfrom=custom      |
| to                        | to@test.tld     | -Dto=custom        |
| X-Mms-Message-Type        | MM4_FORWARD_REQ | -Dmessageid=custom |
| X-Mms-3GPP-Version        | 1.0             | -Dversion=custom   |
| X-Mms-Message-ID          | messageId       |                    |
| X-Mms-Transaction-ID      | transactionId   |                    |
| X-Mms-Request-Status-Code | 0               |                    |

## How to use it
### 1. Download a jar lib
Download [mm4-clien.jar](https://github.com/peterjurkovic/smtp/blob/master/mm4-client.jar)

### 2. Run the command

```
mm4-clien.jar -jar 
```

By default it sends **MM4_FORWARD_REQ** containg an immage. In order to change the type just pass aditional parameter

```
mm4-clien.jar -jar MM4_FORWARD_RES -Dport=25
```
