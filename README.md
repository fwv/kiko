# kiko
A toy-level game server based on netty.
##Based on netty
>Netty is an asynchronous event-driven network application framework 
for rapid development of maintainable high performance protocol servers & clients.  
you can learn more in [Netty:Home](http://netty.io/)  

##Simple
Still developing... I will try my best make kiko simple to use.  

##Landmark  
* 2016/09/13 began to do this thing.
* 2016/09/14 kiko has netty c/s and slf4j log4j. (I found StackOverFlower is a wonderful place)
* 2016/09/19 completed the first vision framework of kiko. (core object, service module, db module, event module)
* 2016/09/21 service module can work correctlly.
* 2016/09/29 kiko has its own RPC frame(kiko-RPC), currently only supports java native Serializable. 
* 2016/10/13 add MultiConsumerExecutor in concurrent tool.
* 2016/10/20 some oop design like "Module Sector ModuleManager" make no sense so I delete them.
* 2016/10/20 kiko-protocol supports Google Protobuf.
