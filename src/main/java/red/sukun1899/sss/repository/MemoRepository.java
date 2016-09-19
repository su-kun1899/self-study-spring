package red.sukun1899.sss.repository;

import java.util.List;

import red.sukun1899.sss.model.Memo;

public interface MemoRepository {

  List<Memo> find();

  List<Memo> findByAuthor(String author);

  void save(Memo item);
}
