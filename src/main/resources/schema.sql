CREATE TABLE topics
(
    topicID INT AUTO_INCREMENT PRIMARY KEY,
    title   VARCHAR(30) NOT NULL
);


CREATE TABLE message
(
    messageId INT AUTO_INCREMENT PRIMARY KEY,
    topicId   INT          NOT NULL,
    author    VARCHAR(50)  NOT NULL,
    text      VARCHAR(100) NOT NULL,
    date      TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (topicId) REFERENCES topics (topicID)
);
