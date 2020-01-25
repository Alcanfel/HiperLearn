import Dao.SchoolDao;
import Entities.Child;
import Entities.School;

import java.util.List;
import java.util.Set;

public class SchoolService {
    private SchoolDao schoolDao = new SchoolDao();

    public SchoolService(){

    }

    public School findSchool(int id){
        return schoolDao.findById(id);
    }

    public void saveSchool(School school){
        schoolDao.save(school);
    }

    public void deleteSchool(School school){
        schoolDao.delete(school);
    }

    public void updateSchool (School school){
        schoolDao.update(school);
    }

    public List<School> findAllSchools(){
        return (List<School>) schoolDao.findAllSchool();
    }

    public Child findChildById(int id){
        return schoolDao.findChildByID(id);
    }
}
