-- [Create Table Statements]
-- matching
-- * RestoreFromTempTable
create table matching (
  id integer not null
  , sub_id integer not null
  , constraint matching_PKC primary key (id,sub_id)
) ;

-- movies
-- * RestoreFromTempTable
create table movies (
  id integer not null
  , genre character varying(255)
  , matching_id character varying(255)
  , title character varying(255)
  , year integer
  , constraint movies_PKC primary key (id)
) ;

-- subscription
-- * RestoreFromTempTable
create table subscription (
  id integer not null
  , subscription_name character varying(255)
  , constraint subscription_PKC primary key (id)
) ;

comment on table matching is 'matching';
comment on column matching.id is 'id';
comment on column matching.sub_id is 'sub_id';

comment on table movies is 'movies';
comment on column movies.id is 'id';
comment on column movies.genre is 'genre';
comment on column movies.matching_id is 'matching_id';
comment on column movies.title is 'title';
comment on column movies.year is 'year';

comment on table subscription is 'subscription';
comment on column subscription.id is 'id';
comment on column subscription.subscription_name is 'subscription_name';


-- [Insert Data Statements]
insert into public.matching(id,sub_id) values 
    (1,1)
  , (1,3)
  , (2,2)
  , (2,4);

insert into public.movies(id,genre,matching_id,title) values 
    (1,'SF',1,'ジュラシック・パーク')
  , (2,'ファンタジー',2,'ハリーポッター');

insert into public.subscription(id,subscription_name) values 
    (1,'AmazonPrime')
  , (2,'Netflix')
  , (4,'Hulu')
  , (3,'U-Next');
