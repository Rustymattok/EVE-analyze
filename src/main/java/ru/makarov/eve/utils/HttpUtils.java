package ru.makarov.eve.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import ru.makarov.eve.model.DataResultObject;
import ru.makarov.eve.model.MetaObject;


public final class HttpUtils {
    private HttpUtils() {

    }

    public static <T> ResponseEntity<DataResultObject<T>> ok(T data) {
        return new ResponseEntity<>(new DataResultObject<>(data), HttpStatus.OK);
    }

    public static <T> ResponseEntity<DataResultObject<T>> ok(T data, MetaObject metaObject) {
        return new ResponseEntity<>(new DataResultObject<>(data, metaObject), HttpStatus.OK);
    }

    public static <T> ResponseEntity<DataResultObject<T>> bad(T data) {
        return new ResponseEntity<>(new DataResultObject<>(data), HttpStatus.BAD_REQUEST);
    }

    public static ResponseEntity<DataResultObject<Void>> noContent() {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    public static <T> ResponseEntity<DataResultObject<T>> withStatus(T data, HttpStatus status) {
        return new ResponseEntity<>(new DataResultObject<>(data), status);
    }

    //todo подготовить респонс на список pageableOk - когда нужна будет пагинация
//    public static <T> ResponseEntity<DataResultObject<List<T>>> pageableOk(Page<T> all) {
//        PageObject page = PageObject.builder()
//                .currentPage(all.getPageable().getPageNumber() + 1)
//                .pagesCount(all.getTotalPages())
//                .total(all.getTotalElements())
//                .pageSize(all.getPageable().getPageSize())
//                .sortField(all.getPageable().getSort().get().findFirst().map(Sort.Order::getProperty).orElse(null))
//                .sortDir(all.getPageable().getSort().get().findFirst().map(Sort.Order::getDirection).orElse(null))
//                .build();
//        MetaObject<PageObject> meta = MetaObject.<PageObject>builder().meta(page).build();
//
//        return HttpUtils.ok(all.getContent(), meta);
//    }
}