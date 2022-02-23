INSERT INTO Users(id, full_name, title, email, birth_date, employer, phone, location, summary)
VALUES(1,
       'Recep Çoban',
       'Senior Software Engineer',
       'recep.coban@mail.com',
       to_date('02-03-1989', 'dd-MM-yyyy'),
       'Yapı Kredi Technology',
       '90 123 45 6789',
       'Istanbul / Turkey',
       'Someone, who has more than six years of insurance/banking experience, who loves to travel, who loves to read books, who loves cats and dogs, who wants to improve himself about new technologies, who loves to watch movies, tv series and documentaries.');

INSERT INTO Certifications(id, user_id, name, provider, url) VALUES(1, 1, 'Oracle Certified Associate, Java SE 8 Programmer', 'Oracle', 'https://www.credly.com/badges/7ed48c34-aa04-4920-806e-3d7696f5c806');
INSERT INTO Certifications(id, user_id, name, provider, url) VALUES(2, 1, 'Building Applications with Microservices, Docker and Spring Boot', 'Bilginç IT Academy', 'https://bilginc.com/evaluation/view/BC000267312');

INSERT INTO Courses(id, user_id, name, provider) VALUES(1, 1, 'Building Applications with Microservices, Docker and Spring Boot', 'Bilginç IT Academy');
INSERT INTO Courses(id, user_id, name, provider) VALUES(2, 1, 'Spring Framework & Hibernate', 'Linux Summer School');
INSERT INTO Courses(id, user_id, name, provider) VALUES(3, 1, 'Java & Database', 'Wissen Akademie');

INSERT INTO Educations(id, user_id, school_name, department_name, start_year, end_year) VALUES(1, 1, 'Istanbul University', 'Computer Engineering', '2010', '2015');

INSERT INTO Experiences(id, user_id, employer, url, position, start_date, end_date, responsibilities, active)
VALUES(1,
       1,
       'Mapfre Insurance',
       'https://www.mapfre.com.tr',
       'Software Developer',
       to_date('11-01-2015', 'dd-MM-yyyy'),
       to_date('21-10-2017', 'dd-MM-yyyy'),
       'Developing and maintaining an insurance project. Developing with Java, JSF, Web services(SOAP), Oracle.', false);
INSERT INTO Experiences(id, user_id, employer, url, position, start_date, end_date, responsibilities, active)
VALUES(2,
       1,
       'Yapı Kredi Bank',
       'https://www.yapikredi.com.tr',
       'Senior Software Developer',
       to_date('23-10-2017', 'dd-MM-yyyy'),
       to_date('21-10-2017', 'dd-MM-yyyy'),
       'Working with Insurance Department. Developing and maintaining a detailed banking and insurance project. Developing with Java, Spring Boot, Web services(SOAP, Rest), Oracle, React Js. Html, Css(Bootstrap, Ant Design).', true);
INSERT INTO Experiences(id, user_id, employer, url, position, start_date, end_date, responsibilities, active)
VALUES(3,
       1,
       'ImonaCloud Technologies',
       'https://www.imona.com',
       'Junior Software Developer(intern)',
       to_date('11-01-2014', 'dd-MM-yyyy'),
       to_date('01-01-2015', 'dd-MM-yyyy'),
       'Developing on their own platform(ImonaCloud) using Java, MySQL, Html, Css(Bootstrap)', false);

INSERT INTO Hobbies(id, user_id, name) VALUES(1, 1, 'Technology');
INSERT INTO Hobbies(id, user_id, name) VALUES(2, 1, 'Coding');
INSERT INTO Hobbies(id, user_id, name) VALUES(3, 1, 'Basketball');
INSERT INTO Hobbies(id, user_id, name) VALUES(4, 1, 'Cycling');
INSERT INTO Hobbies(id, user_id, name) VALUES(5, 1, 'Nature');

INSERT INTO Languages(id, user_id, name, level) VALUES(1, 1, 'English', 'ADVANCED');
INSERT INTO Languages(id, user_id, name, level) VALUES(2, 1, 'Turkish', 'PROFICIENT');

INSERT INTO Projects(id, user_id, name, url, details)
VALUES(1,
       1,
       'Yapı Kredi Bank - Bancassurance',
       null,
       'This is an Insurance Project of the Insurance Department which includes many products. Such as; My Goods Insurance, My Work Insurance, Health Insurance, Natural Disaster Insurance, Motor Insurance, Life Insurance, Private Pension System. Developing and maintaining all of the products of the project. Working on every process of the products. Backend, frontend, database. Developing with Java, Spring Boot, Rest, SOAP, React Js, Oracle, Harmoni(Framework based on Java, Spring, Html, Css, Bootstrap)');
INSERT INTO Projects(id, user_id, name, url, details)
VALUES(2,
       1,
       'Offerte - ePunkt(Freelance)',
       'https://www.offerte-epunkt.ch',
       'A company which is works for cleaning, moving, painting and flooring business line. I worked on backend, frontend and database of the project as a fullstack developer. Developing with C#, ASP.NET, MSSQL, HTML, CSS(Bootstrap).');
INSERT INTO Projects(id, user_id, name, url, details)
VALUES(3,
       1,
       'Social Media Monitoring System',
       null,
       'Searching with some special keyword on social media like facebook, twitter etc. Reporting data with data visualization tools. Developing with Java, MySQL. Using apigee.com''s APIs.');

INSERT INTO Skills(id, user_id, name, level) VALUES(1, 1, 'Java', 'PROFICIENT');
INSERT INTO Skills(id, user_id, name, level) VALUES(2, 1, 'Spring Boot', 'ADVANCED');
INSERT INTO Skills(id, user_id, name, level) VALUES(3, 1, 'Web Services(SOAP, REST)', 'UPPER_INTERMEDIATE');
INSERT INTO Skills(id, user_id, name, level) VALUES(4, 1, 'React Js', 'INTERMEDIATE');
INSERT INTO Skills(id, user_id, name, level) VALUES(5, 1, 'Atlassian(JIRA, Bitbucket, Bamboo)', 'UPPER_INTERMEDIATE');

INSERT INTO Social_Medias(id, user_id, type, url) VALUES(1, 1, 'LINKEDIN', 'https://www.linkedin.com/in/recepcoban');
INSERT INTO Social_Medias(id, user_id, type, url) VALUES(2, 1, 'GITHUB', 'https://github.com/recepcoban');