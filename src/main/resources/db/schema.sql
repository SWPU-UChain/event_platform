BEGIN;

CREATE TABLE IF NOT EXISTS event (
  id SERIAL8 NOT NULL,
  url_md5 CHAR(32) PRIMARY KEY NOT NULL UNIQUE,
  title VARCHAR(255) NOT NULL,
  time TIMESTAMP NOT NULL,
  type VARCHAR(4) NOT NULL,
  keywords jsonb NOT NULL,
  influence DOUBLE PRECISION NOT NULL,
  hot DOUBLE PRECISION NOT NULL,
  summarize TEXT NOT NULL,
  media jsonb NOT NULL,
  relative_event jsonb NOT NULL,
  picture_url VARCHAR(255),
  entity jsonb,
  hot_with_time jsonb,
  label jsonb,
  website VARCHAR (25)
);
CREATE INDEX IF NOT EXISTS event_type_idx on event(type);
CREATE INDEX IF NOT EXISTS event_media_idx on event(media);
CREATE INDEX IF NOT EXISTS event_hot_idx on event(hot);
CREATE INDEX IF NOT EXISTS event_website_idx on event(website);


CREATE TABLE IF NOT EXISTS comment (
  id SERIAL8 NOT NULL PRIMARY KEY,
  url_md5 CHAR(32) NOT NULL REFERENCES event(url_md5),
  content VARCHAR(1000) NOT NULL,
  time TIMESTAMP NOT NULL,
  word jsonb NOT NULL,
  type VARCHAR(4) NOT NULL,
  emotion_rsi DOUBLE PRECISION NOT NULL
);

CREATE INDEX IF NOT EXISTS comment_md5_idx on comment(url_md5);

CREATE TABLE IF NOT EXISTS hot_words (
  id SERIAL8 NOT NULL PRIMARY KEY ,
  time TIMESTAMP NOT NULL ,
  words jsonb NOT NULL
);

COMMIT;