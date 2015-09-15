## SBTJava Demo
basic sbt java  config
## benchmark 

- sbt "run-main name.tanglei.Test HSSF 65535 20 1" —4s, max 65535
- sbt "run-main name.tanglei.Test XSSF 65535 20 1" —50s后,OutofMemory
- sbt "run-main name.tanglei.Test SXSSF 65536 20 1" —5s 
- JExcel(2.6.12) is not faster than apache poi 3.12.
