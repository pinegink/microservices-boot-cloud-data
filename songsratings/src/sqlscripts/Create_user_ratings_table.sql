drop table if exists songs_ratings;
CREATE table songs_ratings (
 song_name varchar (30) primary key,
 rating integer not null
)
