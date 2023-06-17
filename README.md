![Consist_img](https://github.com/codezjt/DataConsist/assets/60995778/ef16ef7a-1ffb-4795-85a3-fc379068c7db)
Canal模拟MySQL slave的交互协议，伪装自己为MySQL slave， 向MySQL Master发送dump请求
MySQL Master收到dump请求，开始推送binary log给slave（Canal）
Canal解析binary log对象（byte流）
