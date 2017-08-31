# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table location_details (
  id                            integer not null,
  user_name                     varchar(255),
  latitude                      varchar(255),
  longitude                     varchar(255),
  timestamp                     varchar(255),
  constraint pk_location_details primary key (id)
);


# --- !Downs

drop table if exists location_details;

