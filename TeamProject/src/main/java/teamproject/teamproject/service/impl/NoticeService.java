package teamproject.teamproject.service.impl;

import lombok.RequiredArgsConstructor;
import teamproject.teamproject.dto.NoticeDTO;
import teamproject.teamproject.persistance.mapper.INoticeMapper;
import teamproject.teamproject.service.INoticeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service("NoticeService")
public class NoticeService implements INoticeService {

    private final INoticeMapper noticeMapper;

/*    @Autowired
    public NoticeService(INoticeMapper noticeMapper) {
        this.noticeMapper = noticeMapper; //객체에 초기화 해줌
    }*/

    @Override
    public List<NoticeDTO> getNoticeList() throws Exception {

        log.info(this.getClass().getName() + ".getNoticeList start!");

        return noticeMapper.getNoticeList();

    }

    @Transactional
    @Override
    public void InsertNoticeInfo(NoticeDTO pDTO) throws Exception {

        log.info(this.getClass().getName() + ".InsertNoticeInfo start!");

        noticeMapper.InsertNoticeInfo(pDTO);
    }

    @Transactional
    @Override
    public NoticeDTO getNoticeInfo(NoticeDTO pDTO) throws Exception {

        log.info(this.getClass().getName() + ".getNoticeInfo start!");

        // 상세보기 할때마다, 조회수 증가하기
        log.info("Update ReadCNT");
        noticeMapper.updateNoticeReadCnt(pDTO);

        return noticeMapper.getNoticeInfo(pDTO);

    }

    @Transactional
    @Override
    public void updateNoticeInfo(NoticeDTO pDTO) throws Exception {

        log.info(this.getClass().getName() + ".updateNoticeInfo start!");

        noticeMapper.updateNoticeInfo(pDTO);

    }

    @Transactional
    @Override
    public void deleteNoticeInfo(NoticeDTO pDTO) throws Exception {

        log.info(this.getClass().getName() + ".deleteNoticeInfo start!");

        noticeMapper.deleteNoticeInfo(pDTO);

    }
}
