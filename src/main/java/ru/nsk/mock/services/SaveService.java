package ru.nsk.mock.services;

import org.springframework.stereotype.Service;
import ru.nsk.mock.utils.RequestLogger;

import java.util.Map;

/**
 * @author Andrei Durkin <a.durkin@goodt.me>
 * @created 08.06.2022
 */

@Service
public class SaveService {

    public void saveData(Map headers, String data, String endPoint) {
        RequestLogger.log(endPoint + "\n");
        RequestLogger.log("\n============== REQUEST HEADERS =================\n");
        headers.forEach((key, value) -> RequestLogger.log("{%s} : {%s}", key, value));
        RequestLogger.log("\n============== REQUEST BODY ====================\n");
        RequestLogger.log(data);
        System.out.println("========== REQUEST SUCCESSFULLY PROCEED ============ ");
    }
}
