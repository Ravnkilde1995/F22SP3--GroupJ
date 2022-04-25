select * from database1.msusers;
update msusers set username = 'ole' where userid = 2;
update msusers set password = 'ole1' where userid = 2;
select * from msusers where username like 'a%';

create schema footballTournament;
use footballTournament;
create table if not exists teams(
teamid int primary key auto_increment, 
teamname varchar(15),
teammembers int,
numberofgoals int,
points int
);

create table if not exists tournament(
tournamentid int primary key auto_increment,
starttime int,
endtime int,
date varchar(8),
tournamentname varchar(50)
);

create table if not exists matches(
matchid int primary key auto_increment,
teamoneid int,
teamtwoid int,
matchdate int,
matchtime int,
matchmonth int,
foreign key(teamoneid) references teams(teamid),
foreign key(teamtwoid) references teams(teamid)
);

