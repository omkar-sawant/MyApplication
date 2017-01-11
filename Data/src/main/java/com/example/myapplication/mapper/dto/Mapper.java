package com.example.myapplication.mapper.dto;

import java.util.List;

/**
 * Created by A653401 on 02-01-2017.
 */

public interface Mapper<M, D> {

    D modelToData(M model);

    M dataToModel(D data);

    List<M> dataListToModelList(List<D> data);

    List<D> modelLisToDataList(List<M> model);
}
