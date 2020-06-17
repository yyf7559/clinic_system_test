package dao;

import entity.Medicine;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
@Repository
public class MedicineDaoImpl implements MedicineDao{
    @Resource
    private SessionFactory sessionFactory;

    @Override
    public List<Medicine> getAllMedicineByMap(Map<String,Object> map){
        Session session = sessionFactory.getCurrentSession();
        StringBuffer hql = new StringBuffer("FROM Medicine m left outer join fetch m.prescriptiontype left outer join fetch m.manufacturer  where 1=1 ");
        List<Object> str = new ArrayList<>();
        if(map.get("prescriptionTypeId") != null && !"".equals(map.get("prescriptionTypeId"))){
            hql.append(" and m.prescriptiontype.id = ?");
            str.add((long)Integer.parseInt(map.get("prescriptionTypeId").toString()));
        }
        if(map.get("name") != null && !"".equals(map.get("name"))){
            hql.append(" and (m.medicinename like ? or m.medicineno like ? ) ");
            str.add("%"+map.get("name")+"%");
            str.add("%"+map.get("name")+"%");
        }
        hql.append(" order by m.id ");
        Query query = session.createQuery(hql.toString());
        for (int i = 0;i<str.size();i++){
            query.setParameter(i,str.get(i));
        }
        return  query.list();
    }

}
