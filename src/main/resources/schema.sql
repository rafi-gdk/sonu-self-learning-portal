CREATE TABLE IF NOT EXISTS topics (
        topic_id varchar(50) not null,
        topic_name varchar(50),
        primary key (topic_id)
    );


 CREATE TABLE IF NOT EXISTS sub_topics (
        sub_topic_content TEXT,
        sub_topic_id varchar(50) not null,
        sub_topic_name varchar(50),
        topic_id varchar(50),
        primary key (sub_topic_id),
		foreign key (topic_id) references topics
    );
