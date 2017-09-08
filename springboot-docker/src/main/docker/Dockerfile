# FROM指定使用哪个镜像作为基准
FROM openjdk:8-jdk-alpine
# VOLUME为挂载路径  -v
VOLUME /tmp
# ADD为复制文件到镜像中
ADD springboot-docker.jar app.jar
# RUN为初始化时运行的命令  touch更新app.jar
RUN sh -c 'touch /app.jar'
# ENV为设置环境变量
ENV JAVA_OPTS=""
# ENTRYPOINT为启动时运行的命令
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar" ]