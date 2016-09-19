package red.sukun1899.sss.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

import red.sukun1899.sss.model.Memo;
import red.sukun1899.sss.repository.MemoRepository;

@Service
public class MemoService {

  private MemoRepository memoRepository;

  @Autowired
  public MemoService(MemoRepository memoRepository) {
    this.memoRepository = memoRepository;
  }

  public Memo join(String memo, String author) {
    Memo item = new Memo();
    item.setMemo(memo);
    item.setAuthor(author);
    item.setCreated(new Date());

    return item;
  }

  public List<Memo> readAll() {
    return getMemoRepository().find();
  }

  public List<Memo> readByAuthor(String author) {
    return getMemoRepository().findByAuthor(author);
  }

  public void write(String memo, String author) {
    Memo item = new Memo();
    item.setMemo(memo);
    item.setAuthor(author);

    getMemoRepository().save(item);
  }
  
  public MemoRepository getMemoRepository() {
    return memoRepository;
  }
}
