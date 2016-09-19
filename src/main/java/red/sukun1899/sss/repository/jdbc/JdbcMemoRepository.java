package red.sukun1899.sss.repository.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

import red.sukun1899.sss.model.Memo;
import red.sukun1899.sss.repository.MemoRepository;

@Repository
public class JdbcMemoRepository implements MemoRepository {

  private JdbcTemplate jdbcTemplate;

  @Autowired
  public JdbcMemoRepository(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  @Override
  public List<Memo> find() {
    return getJdbcTemplate().query("SELECT MEMO, AUTHOR FROM MEMO ORDER BY CREATED ASC", (resultSet, i) -> {
      Memo item = new Memo();
      item.setMemo(resultSet.getString("MEMO"));
      item.setAuthor(resultSet.getString("AUTHOR"));

      return item;
    });
  }

  @Override
  public List<Memo> findByAuthor(String author) {
    return getJdbcTemplate().query("SELECT MEMO, AUTHOR FROM MEMO WHERE AUTHOR = ? ORDER BY CREATED ASC", (resultSet, i) -> {
      Memo item = new Memo();
      item.setMemo(resultSet.getString("MEMO"));
      item.setAuthor(resultSet.getString("AUTHOR"));

      return item;
    }, author);
  }

  @Override
  public void save(Memo item) {
    getJdbcTemplate().update("INSERT INTO MEMO (MEMO, AUTHOR, CREATED) VALUES (?, ?, CURRENT_TIME)",
        item.getMemo(), item.getAuthor());
  }

  public JdbcTemplate getJdbcTemplate() {
    return jdbcTemplate;
  }
}
