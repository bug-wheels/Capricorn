package com.github.bw.capricorn.server.endpoint.infrastructure.mapper;

import static com.github.bw.capricorn.server.endpoint.infrastructure.mapper.NamespaceDynamicSqlSupport.createTime;
import static com.github.bw.capricorn.server.endpoint.infrastructure.mapper.NamespaceDynamicSqlSupport.dcId;
import static com.github.bw.capricorn.server.endpoint.infrastructure.mapper.NamespaceDynamicSqlSupport.description;
import static com.github.bw.capricorn.server.endpoint.infrastructure.mapper.NamespaceDynamicSqlSupport.id;
import static com.github.bw.capricorn.server.endpoint.infrastructure.mapper.NamespaceDynamicSqlSupport.name;
import static com.github.bw.capricorn.server.endpoint.infrastructure.mapper.NamespaceDynamicSqlSupport.namespace;
import static com.github.bw.capricorn.server.endpoint.infrastructure.mapper.NamespaceDynamicSqlSupport.updateTime;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

import com.github.bw.capricorn.server.endpoint.infrastructure.model.Namespace;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import javax.annotation.Generated;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.dynamic.sql.BasicColumn;
import org.mybatis.dynamic.sql.delete.DeleteDSLCompleter;
import org.mybatis.dynamic.sql.delete.render.DeleteStatementProvider;
import org.mybatis.dynamic.sql.insert.render.InsertStatementProvider;
import org.mybatis.dynamic.sql.insert.render.MultiRowInsertStatementProvider;
import org.mybatis.dynamic.sql.select.CountDSLCompleter;
import org.mybatis.dynamic.sql.select.SelectDSLCompleter;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.update.UpdateDSL;
import org.mybatis.dynamic.sql.update.UpdateDSLCompleter;
import org.mybatis.dynamic.sql.update.UpdateModel;
import org.mybatis.dynamic.sql.update.render.UpdateStatementProvider;
import org.mybatis.dynamic.sql.util.SqlProviderAdapter;
import org.mybatis.dynamic.sql.util.mybatis3.MyBatis3Utils;

@Mapper
public interface NamespaceMapper {

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    BasicColumn[] selectList = BasicColumn.columnList(id, dcId, name, description, createTime, updateTime);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type = SqlProviderAdapter.class, method = "select")
    long count(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @DeleteProvider(type = SqlProviderAdapter.class, method = "delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type = SqlProviderAdapter.class, method = "insert")
    int insert(InsertStatementProvider<Namespace> insertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type = SqlProviderAdapter.class, method = "insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<Namespace> multipleInsertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type = SqlProviderAdapter.class, method = "select")
    @ResultMap("NamespaceResult")
    Optional<Namespace> selectOne(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type = SqlProviderAdapter.class, method = "select")
    @Results(id = "NamespaceResult", value = {
        @Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
        @Result(column = "dc_id", property = "dcId", jdbcType = JdbcType.INTEGER),
        @Result(column = "name", property = "name", jdbcType = JdbcType.VARCHAR),
        @Result(column = "description", property = "description", jdbcType = JdbcType.VARCHAR),
        @Result(column = "create_time", property = "createTime", jdbcType = JdbcType.TIMESTAMP),
        @Result(column = "update_time", property = "updateTime", jdbcType = JdbcType.TIMESTAMP)
    })
    List<Namespace> selectMany(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @UpdateProvider(type = SqlProviderAdapter.class, method = "update")
    int update(UpdateStatementProvider updateStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, namespace, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, namespace, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int deleteByPrimaryKey(Integer id_) {
        return delete(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insert(Namespace record) {
        return MyBatis3Utils.insert(this::insert, record, namespace, c ->
            c.map(id).toProperty("id")
                .map(dcId).toProperty("dcId")
                .map(name).toProperty("name")
                .map(description).toProperty("description")
                .map(createTime).toProperty("createTime")
                .map(updateTime).toProperty("updateTime")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertMultiple(Collection<Namespace> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, namespace, c ->
            c.map(id).toProperty("id")
                .map(dcId).toProperty("dcId")
                .map(name).toProperty("name")
                .map(description).toProperty("description")
                .map(createTime).toProperty("createTime")
                .map(updateTime).toProperty("updateTime")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertSelective(Namespace record) {
        return MyBatis3Utils.insert(this::insert, record, namespace, c ->
            c.map(id).toPropertyWhenPresent("id", record::getId)
                .map(dcId).toPropertyWhenPresent("dcId", record::getDcId)
                .map(name).toPropertyWhenPresent("name", record::getName)
                .map(description).toPropertyWhenPresent("description", record::getDescription)
                .map(createTime).toPropertyWhenPresent("createTime", record::getCreateTime)
                .map(updateTime).toPropertyWhenPresent("updateTime", record::getUpdateTime)
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<Namespace> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, namespace, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<Namespace> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, namespace, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<Namespace> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, namespace, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<Namespace> selectByPrimaryKey(Integer id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, namespace, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateAllColumns(Namespace record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalTo(record::getId)
            .set(dcId).equalTo(record::getDcId)
            .set(name).equalTo(record::getName)
            .set(description).equalTo(record::getDescription)
            .set(createTime).equalTo(record::getCreateTime)
            .set(updateTime).equalTo(record::getUpdateTime);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(Namespace record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalToWhenPresent(record::getId)
            .set(dcId).equalToWhenPresent(record::getDcId)
            .set(name).equalToWhenPresent(record::getName)
            .set(description).equalToWhenPresent(record::getDescription)
            .set(createTime).equalToWhenPresent(record::getCreateTime)
            .set(updateTime).equalToWhenPresent(record::getUpdateTime);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKey(Namespace record) {
        return update(c ->
            c.set(dcId).equalTo(record::getDcId)
                .set(name).equalTo(record::getName)
                .set(description).equalTo(record::getDescription)
                .set(createTime).equalTo(record::getCreateTime)
                .set(updateTime).equalTo(record::getUpdateTime)
                .where(id, isEqualTo(record::getId))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKeySelective(Namespace record) {
        return update(c ->
            c.set(dcId).equalToWhenPresent(record::getDcId)
                .set(name).equalToWhenPresent(record::getName)
                .set(description).equalToWhenPresent(record::getDescription)
                .set(createTime).equalToWhenPresent(record::getCreateTime)
                .set(updateTime).equalToWhenPresent(record::getUpdateTime)
                .where(id, isEqualTo(record::getId))
        );
    }
}