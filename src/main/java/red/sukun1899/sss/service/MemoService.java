package red.sukun1899.sss.service;

import org.springframework.stereotype.Service;

import java.util.Date;

import red.sukun1899.sss.model.Memo;

@Service
public class MemoService {

  public Memo join(String memo, String author) {
    Memo item = new Memo();
    item.setMemo(memo);
    item.setAuthor(author);
    item.setCreated(new Date());

    return item;
  }
}
