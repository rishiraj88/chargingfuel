# chargingfuel
starting a charging session with ChargePoint

## 3 Apps are to be Developed:
- autodash: driver app AutoDash
- gateway: API gateway and controller for ChargeOnTheGo
- authorization: Authorization service for ChargeOnTheGo

## Saved data goes to:
- driver app: for displaying charging activity , for account overview and for monthly statements;
- cloud platform: for station usage (30-day reports etc.), station status (current distribution), real-time power rating graphs and other analysis reports.

## Cloud app for EMSP and ACL:
ACL controls who can access specific stations and offers special pricing using connections to boost driver loyalty.

A simplistic view of such an access control list (ACL) would look like:
<code>{
driver group (employee, others),
access hours (weekday officehours, nights and weekends)
}</code>