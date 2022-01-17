package mvc.score;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//역할: 컨트롤러가 보내준 데이터를 처리하여 저장소쪽으로 보내주거나
//      저장소가 가져온 데이터를 처리하여 컨트롤러쪽으로 보내주는 역할
//@Component 붙여도 되지만 Service 가 더 명확하다
//객체 위임
@Service
public class ScoreService {

    private final ScoreRepository scoreRepository;

    @Autowired
    public ScoreService(ScoreRepository scoreRepository) {
        this.scoreRepository = scoreRepository;
    }

    //점수 전체조외 요청 중간처리
    public List<Score> findAll() {
        List<Score> scoreList = scoreRepository.findAll();
        //repo 가 가져온 데이터 중간처리
        // ......................
        return scoreList;
    }

    //점수 등록 요청 중간처리
    public void save(Score score) {
        score.calcTotal(); //총점, 평균계산
        score.changeMarkName(); //마킹네임저장
        scoreRepository.save(score); //세이브
    }

    //점수 삭제 요청 중간처리
    public void remove(int stuNum) {
        scoreRepository.remove(stuNum);
    }

    //점수 개별조회 요청 중간처리
    public Score findOne(int stuNum) {
        Score score = scoreRepository.findOne(stuNum);
        //중간처리 ...........................
        return score;
    }
}
