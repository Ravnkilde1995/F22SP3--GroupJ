create schema footballTournament;
use footballTournament;

create table if not exists Tournament(
tournamentID int primary key auto_increment,
startTime int, 
endTime int,
date varchar(45),
tournamentName varchar(45)
);

create table if not exists Teams(
teamID int primary key auto_increment,
teamName varchar(45),
teamMembers int,
numberOfGoals int,
points int
);

create table if not exists Matches(
matchDate int,
matchTime int, 
matchMonth int,
teamOneID int,
teamTwoID int,
foreign key (teamOneID) references teams (teamid),
foreign key (teamTwoID) references teams (teamid)
);

create table if not exists Player(
playerID int primary key auto_increment,
firstName varchar(45),
lastName varchar(45),
age int
);




