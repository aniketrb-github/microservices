Rabbit MQ Setup

1) Pre-requisite: Erlang.
download it from: https://www.erlang.org/downloads
OTP 22.2 Windows 64-bit Binary File 
PS: Take the latest stable version available

2) Download RabbitMQ
download it from: https://www.rabbitmq.com/install-windows.html#installer
windows installer: rabbitmq-server-3.8.2.exe
PS: Take the latest stable version available

Open sbin(CommandPrompt of RabbitMQ) in administrator mode (https://www.rabbitmq.com/install-windows.html#installer)
To stop the broker or check its status, use rabbitmqctl.bat in sbin (as an administrator).
> rabbitmqctl.bat stop	
> rabbitmqctl.bat status

3) Download Zipkin JAR
or Google: Zipkin Quickstart
open CMD/GitBASH & execute following command for Zipkin Server download:
> curl -sSL https://zipkin.io/quickstart.sh | bash -s
It will download the JAR file to current location of CMD

> set RABBIT_URI=amqp://localhost
> java -jar zipkin.jar
Zipkin Port: 9411
Once it Zipkin is UP, check the dashboard: http://127.0.0.1:9411/