package storePractice.store.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import storePractice.store.domain.Member;
import storePractice.store.service.MemberCreateDto;
import storePractice.store.service.MemberService;
import storePractice.store.service.MemberServiceImpl;

@RequiredArgsConstructor
@RestController
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/api/member/")
    public ResponseEntity<Member> createMember(MemberCreateDto memberCreateDto){
        Member member = memberService.createMember(memberCreateDto);
        return new ResponseEntity<>(member, HttpStatus.OK);
    }

    @DeleteMapping("/api/member/${name}")
    public void deleteMember(@RequestParam String name){
        memberService.deleteMember(name);
    }

}
