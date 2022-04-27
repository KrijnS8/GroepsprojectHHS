package nl.groep4b;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class JsonConverterTest {
    @Test
    public void test() {
        ArrayList<StudentBean> list = generateStudentBeanList(500);
        assertTrue(testObjectArrayListToJson(list));
    }

    private boolean testObjectArrayListToJson(ArrayList<StudentBean> list) {
        String filePath = "testfiles/output/student.json";
        JsonConverter.objectArrayListToJson(list, filePath);

        ArrayList<StudentBean> outputList = JsonConverter.jsonToObjectArrayList(filePath, StudentBean.class);
        for (int i = 0; i < outputList.size(); i++) {
            if (!list.get(i).equals(outputList.get(i))) return false;
        }
        return true;
    }

    private ArrayList<StudentBean> generateStudentBeanList(int length) {
        ArrayList<StudentBean> list = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            StudentBean bean = new StudentBean();
            bean.setName(getRandomString(15, false));
            bean.setAge(getRandomNumber(17, 25));
            bean.setStudentNr(getRandomNumber(10000000, 99999999));
            bean.setPasswordHashed(PasswordHasher.hashToString(getRandomString(10, true)));
            list.add(bean);
        }
        return list;
    }

    private String getRandomString(int length, boolean numbers) {
        return RandomStringUtils.random(length, true, numbers);
    }

    private int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
}
