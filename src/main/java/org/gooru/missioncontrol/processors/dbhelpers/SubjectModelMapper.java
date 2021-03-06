
package org.gooru.missioncontrol.processors.dbhelpers;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;


public class SubjectModelMapper implements ResultSetMapper<SubjectModel> {

  @Override
  public SubjectModel map(int index, ResultSet r, StatementContext ctx) throws SQLException {
    SubjectModel model = new SubjectModel();
    model.setId(r.getString("id"));
    model.setName(r.getString("name"));
    model.setCode(r.getString("code"));
    model.setCategoryId(r.getString("category_id"));
    return model;
  }

}
