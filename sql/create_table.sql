drop database uok_mf;
create database uok_mf;
use uok_mf;

CREATE TABLE `students` (
  `index_no` varchar(20) NOT NULL,
  `nic` varchar(20) NOT NULL,
  `name` varchar(200) NOT NULL,
  `gender` enum('MALE','FEMALE') NOT NULL,
  `batch` varchar(20) NOT NULL,
  PRIMARY KEY (`index_no`,`nic`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;