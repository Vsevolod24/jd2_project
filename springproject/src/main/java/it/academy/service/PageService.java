package it.academy.service;

import it.academy.dao.PageDao;
import it.academy.dao.SensorDao;
import it.academy.model.Sensor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

@Service
public class PageService {

    private SensorDao sensorDao;

    private PageDao pageDao;

    @Autowired
    public PageService(SensorDao sensorDao, PageDao pageDao) {
        this.sensorDao = sensorDao;
        this.pageDao = pageDao;
    }

    private static List<Sensor> sensors = new ArrayList<Sensor>();

    private static final int NUM_SENSORS = 30;

    private static final int MIN_SENSOR_NUM = 500;


    private static List<Sensor> buildSensors() {

        if (sensors.isEmpty()) {
            IntStream.range(0, NUM_SENSORS).forEach(n -> {
                sensors.add(new Sensor(MIN_SENSOR_NUM + n + 1));
            });
        }
        return sensors;
    }

    final private List<Sensor> pageSensors = buildSensors();

    public Page<Sensor> findPaginated(Pageable pageable) {
        int pageSize = pageable.getPageSize();
        int currentPage = pageable.getPageNumber();
        int startItem = currentPage * pageSize;
        List<Sensor> list;

        if (pageSensors.size() < startItem) {
            list = Collections.emptyList();
        } else {
            int toIndex = Math.min(startItem + pageSize, pageSensors.size());
            list = pageSensors.subList(startItem, toIndex);
        }

        Page<Sensor> sensorPage =
                new PageImpl<Sensor>(list, PageRequest.of(currentPage, pageSize), pageSensors.size());
        return sensorPage;
    }
}





















