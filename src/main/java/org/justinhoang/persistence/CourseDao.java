//package org.justinhoang.persistence;
//
//import org.justinhoang.entity.Course;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.jpa.repository.QueryHints;
//import org.springframework.data.repository.CrudRepository;
//
//import javax.persistence.QueryHint;
//
//public interface CourseDao extends CrudRepository<Course, Long>
//{
//    @Query("select distinct c from Course c join fetch c.mentor")
//    QueryHints(value = {@QueryHint(name=
//            org.hibernate.jpa.QueryHints.HINT_PASS_DISTINCT)})
//}
