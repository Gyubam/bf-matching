package website.bfmatching.repository.querydsl;

import com.querydsl.jpa.impl.JPAQueryFactory;
import website.bfmatching.Dto.MemberDto;
import website.bfmatching.Dto.MemberTeamDto;
import website.bfmatching.Dto.QMemberTeamDto;
import website.bfmatching.entity.QMember;
import website.bfmatching.entity.QTeam;

import javax.persistence.EntityManager;
import java.util.List;

public class MemberRepositoryQuerydslImpl implements MemberRepositoryQuerydsl {

    private final JPAQueryFactory queryFactory;

    public MemberRepositoryQuerydslImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }


    @Override
    public List<MemberTeamDto> findAllMemberWithTeamByQuerydsl() {
        return queryFactory
                .select(new QMemberTeamDto(
                        QMember.member.id,
                        QMember.member.loginId,
                        QTeam.team.id,
                        QTeam.team.teamName
                ))
                .from(QMember.member)
                .leftJoin(QMember.member.team, QTeam.team)
                .fetch();
    }
}
