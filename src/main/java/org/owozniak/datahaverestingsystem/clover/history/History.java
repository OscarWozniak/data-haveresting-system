//package org.owozniak.datahaverestingsystem.clover.history;//package org.owozniak.datahaverestingsystem.clover.history;
//
//import lombok.AccessLevel;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import lombok.experimental.FieldDefaults;
//
//import javax.persistence.*;
//import java.util.Date;
//
//@Entity
//@Data
//@NoArgsConstructor
//@FieldDefaults(level = AccessLevel.PRIVATE)
//public class History {
//
//  @Id
//  @GeneratedValue
//  long id;
//
//  @OneToMany
//  Historable history;
//  Date date;
//  int count;
//  @Enumerated(EnumType.STRING)
//  HistoryType type;
//}
