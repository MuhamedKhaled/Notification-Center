FROM mysql:latest

ENV MYSQL_ROOT_PASSWORD 123
ENV MYSQL_DATABASE notification
ENV MYSQL_USER admin
ENV MYSQL_PASSWORD admin

ADD setup.sql /docker-entrypoint-initdb.d
