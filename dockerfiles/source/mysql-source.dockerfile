FROM mysql:latest

ENV MYSQL_ROOT_PASSWORD root
ENV MYSQL_DATABASE sample
ENV MYSQL_USER user
ENV MYSQL_PASSWORD password

COPY dockerfiles/source/my.cnf /etc/mysql/my.cnf

EXPOSE 3306

CMD ["mysqld"]

