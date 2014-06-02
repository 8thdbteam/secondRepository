package com.example.planboardv3;


import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;

public class Words extends Activity {

    DataListView list;
     
    IconTextListAdapter adapter;
 
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         
        // 타이틀 없애기
        requestWindowFeature(Window.FEATURE_NO_TITLE);
 
        // 리스트뷰 객체 생성
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.FILL_PARENT);
        list = new DataListView(this);
 
        // 어댑터 객체 생성
        adapter = new IconTextListAdapter(this);
 
        // 아이템 데이터 만들기
        Resources res = getResources();
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "가드(Guard)", " 게임을 진행해 나가는 코트 안의 사령탑, 가드는 키와는 크게 상관이 없지만 드리블과 민첩성이 있어야 하며 명석한 두되가 절대적으로 요구되는 포지션"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "건앤런(Gun&Run)", "빠르게 공격하는 것, 재빨리 공을 갖고 들어가 수비할 틈을 주지않고 공격하는 플레이"));        
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "게임타임(Game Time)", "경기시간은 1쿼터당 10분, 총40분이며 연장전은 5분"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "골 텐딩(Goaltending)", "슛한 공이 림 위에 있을 때 이것을 건드리는 경우. 공격측이 건드리면 노골 선언이 되고 수비측이 건드리면 골로 인정"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "넘버 플레이(Number Play)", "사전에 약속된 플레이로, 숫자를 통해 공격을 지시함"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "노룩패스(No Look Pass )", "상대방 수비수를 속이기 위해 다른 방향을 응시한채로 패스하는 고난도의 플레이를 말함"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "더블 드리블(Double Dribble)", "드리블하던 볼을 잡았다가 다시 드리블한 경우"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "더블 포스트(Double Post)", "장신 선수 2명이 자유투 선상에서 하는 공격"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "더블클러치(Double Clutch)", "공중에 몸이 뜬 상태에서 한번 더 점프하는 것, 일단 점프슛 모션으로 수비를 속인 뒤에 체공 중에 재차 뛰어올라 노마크 상태를 만들어 골밑 레이업슛이나 어시스트를 하는 기술"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "더블팀(Double Team)", "볼을 가진 공격수를 수비수 2명이 에워싸 실책을 유발시키는 수비방법. 수비수 3명이 에워싸는 수비는 트리플팀(Triple Team)이라고 부름"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "더블파울(Double Foul)", "양 팀 선수가 동시에 파울을 범하는 것. 이 경우 두 선수에게 각각 1개씩의 개인파울이 기록되며 심판은 머리 위로 주먹을 쥔 두팔을 X자로 교차시켜며 더블파울을 표시한다. 이어 심판은 공격권을 가르기 위해 점프볼을 선언하는데 이때 점프볼은 파울을 범한 선수 둘이서 하게 되면 가장 가까운 서클에서 실시"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "덩크슛(Dunk Shoot)", "볼을 림 위에서 직접 던져 넣는 슛"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "도어매트팀 (Door Mat Team)", "승리의 발판이 된다는 의미, 상대팀에게 쉽게 승리를 헌납하는 약팀을 이름"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "도징(Dodging)", "발의 측면을 이용, 진행 방향을 급격히 바꾸며 상대 수비를 피해가는 것"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "드리블(Dribble)", " 볼을 바닥에 튀기며 코트내에서 이동하는 것. 드리블할 때는 트레블링에 걸리지 않으므로 볼을 가진 채 이동하는 방법"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "드리블 스틸(Dribble Steal)", "과감하게 볼을 빼앗는 공격형 디펜스로 상대방이 드리블하고 있는 공을 뺏는 것"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "디스퀄리파잉 파울(Disqualfying Foul)", "정도에 지나친, 스포츠맨십에 어긋난 파울, 이 경우 즉시 실격되어 퇴장을 당할 수도 있음"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "디펜스(Defense)", "방어 또는 방어하는 팀 "));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "러닝 드리블(Running Dribble)", "달리면서 하는 드리블"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "러닝게임(Running Game)", "트랜지션이 많은 속공위주의 게임"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "레귤러시즌(Regular Season)", "정규시즌을 말함.NBA 레귤러시즌은 매년 11월 첫주나 둘째주에 개막, 다음해 4월까지 팀당 82게임을 치름.게임의 형태는 컨퍼런스 내 다른 디비전 팀들과는 홈과 어웨이 2게임씩을 치르고, 다른 컨퍼런스의 팀들과도 홈과 어웨이 1게임씩, 총2게임을 치름.이를 더블-원(double-one)방식이라고 하는데, 즉 디비전과 컨퍼런스를 경계로 리그 구분이 멀어질수록 그쪽 팀과는 경기수가 1/2, 1/4로 적어지는 형태"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "레이업 슛(Lay-up Shoot)", "점프한 후 골 밑에서 언더핸드로 던지는 슛"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "렉드로우 드리블(Leg Through Dribble)", "앞뒤로 벌린 다리 사이로 볼을 컨트롤하며 방향 전환을 하는 기술"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "로스터(Roster)", " 선수등록 명단을 말함. 2군이 없는 NBA에서는 12명이 로스터에 들어감.다만 부상자 리스트에는 3명까지만 등록할수 있음"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "로우 포스트(Low Post)", "프리존 앤드라인쪽으로 3초 이상 머무는 것이 금지된 지역"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "로테이션(Rotation)", "5명의 수비수가 마크하는 공격수를 차례로 바꾸면서 수비가 무너지는 것을 막는 것"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "록 스텝(Lock Step)", "디펜스를 완전히 제치고 나서 패스를 받는 것"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "롤 오프 스크린(Roll Off Screen)", "플레이에서 스크리너가 백턴을 해 자신의 수비를 제어하면서 골방향으로 달리는 플레이"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "롱 글라이드(Long Glide)", "전속력으로 달리는 공격수를 수비하는 스탭"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "루즈 볼(Loose Ball)", "어느 팀에게도 속해 있지 않은 볼"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "리바운드(Rebound)", "골인되지 않고 림이나 백보드에 맞아서 튕겨 나온 볼을 캐치 하는 것"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "리허빌리테이션(Rehabilitation)", "경기 중 부상당한 부위를 응급처치하는 것"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "릴리스(Release)", "패스나 슛을 할 때 볼을 놓는 것 또는 그 순간"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "릴리스 타이밍(Release Time)", "볼이 손을 벗어나는 시점"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "마크(Mark)", "수비수가 자신이 맡은 공격수에 붙어서 수비하는 것. 디펜스 체크라고도 함"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "매치업(Match Up)", "공격수와 수비수가 1:1로 맞대결하는 상황 또는 서로 수비해야하는 선수를 지칭, 주로 같은 포지션끼리 매치업이 이루어짐"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "맨투맨 디펜스(Man to Man Defense)", " 5명의 수비수가 각각 1대1로 상대를 막는 것. 대인 방어"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "미스매치(Mismatch)", "더욱 원활한 공격을 하기 위한 공격 포메이션을 말함. 예를 들어 외곽에서 키 큰 센터가 작은 가드에게 따라 붙으면 그 재빠른 동작을 따라가지 못해 불리한 상황이 됨. 반대로 인사이드에서 장신의 오펜스에 단신의 디펜스가 따라 붙으면 골밑에서는 단연 공격측이 유리해져 쉽게 슛을 넣을 수 있음"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "바스켓 인터페이스(Basket Interface)", "슛한 볼이 포물선의 정점에서 떨어져 림에 닿기까지, 또는 볼이 림 위에 실려 있을 때 수비수가 볼이나 백보드에 닿은 경우, 슛이 성공한 것으로 인정. 공격팀이 똑같은 플레이를 하는 경우에는 가장 가까운 사이드 라인에서 상대방 팀의 드로인이 됨"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "바스켓카운트(Basket Count)", "슛 동작시 상대편 수비수가 반칙(수비반칙)을 했을 경우 그 슛이 들어가면 점수로 인정됨과 동시에 추가 자유투 하나가 주어짐"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "바운드 패스(Bound Pass)", "볼을 튀겨서 주는 패스 (장신이 수비시 이용)"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "바이얼레이션(Violation)", "`룰 위반'이란 뜻으로 파울에 속하지 않는 반칙. 바이얼레이션을 범했을 경우 공격권이 상대팀에게 넘어가게 되지만 해당선수에게는 개인파울이 적용되지 않음"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "박스아웃(Box Out)", "리바운드를 먼저 잡기위해 페인트존 밖으로 상대선수를 최대한 밀어내는 행위"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "박스원(Box One)", "상대의 슈터나 특정 선수 1명을 집중마크하고 나머지는 지역방어형태를 취하는 수비"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "백 도어(Back Door)", "볼을 갖고 있지 않은 2명의 선수가 협력하여 스크린플레이를 구사하며 2 대 1의 상황을 만들어 득점과 연결하는 플레이"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "백 슛(Back Shoot)", "골대를 직접 노리는 것이 아니라 백보드에 한 번 볼을 맞히고 림에 넣는 슛"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "백 스크린(Back Screen)", "포스트맨을 이용해 재빠른 움직임으로 달리면서 스크린 상태를 만들어 자신의 수비수를 따돌리는 플레이"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "백 턴(Back Turn)", "자신을 마크해 오는 수비수를 등지고 회전하여 속이는 방법"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "백 턴 드리블(Back Turn Dribble)", "턴하여 뒤로 도는 순간에 볼을 컨트롤하고 있는 손을 좌우 또는 우좌로 바꾸어 방향 전환하는 방법"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "백업(Back Up)", "주전선수가 벤치에서 쉬고 있는 동안 코트에 나와 짧은 시간동안 그역할을 수행하는 후보선수"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "백코트(Back Court)", "원래는 자신들이 지키는 코트를 가리키지만 후면의 위치에 있는 포지션, 즉 2명의 가드를 말함.백코트가 약하다고 하면 가드의 전력이 부족하다는 뜻"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "버저비터(Buzzer Beater)", "쿼터별 종료 버저와 함께 터지는 극적인 골. 버저가 울리는 순간 슈팅한 볼은 슈터의 손을 떠나있어야 득점을 인정받을 수 있음"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "베이스볼 패스(Baseball Pass)", "볼을 던지는 동작이 야구의 투구폼과 유사하다고 해서 붙여진 이름. 볼을 멀리 빠르게 보낼 수 있어 속공시 자주 사용"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "벤치스코어(Bench Score)", "스타팅멤버 5명을 제외한 나머지 경기도중 투입되는 교체 선수들이 기록한 포인트를 합산한 것. 벤치스코어가 낮은 팀은 주전들의 체력소모가 심한 반면 벤치스코어가 높은 팀은 선수 기용에 여유가 있어 장기 레이스에 절대적으로 유리"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "볼핸드링(Ball Handling)", "볼컨트롤능력과 거의 같은 뜻.공을 확실히 킵하여 자신의 생각대로 요리할 수 있어야 함"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "블로킹 슛(Blocking Shoot)", "공격팀의 슛을 막거나 쳐내며 득점을 저지하는 플레이"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "블록(Block)", "상대의 슛을 공중에서 멈추게 하거나 쳐내는 것"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "비하인드 더 백 패스(Behind The Back Pass)", "팔을 몸 뒤로 돌려서 손목의 스냅을 사용하여 패스 하는 기술"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "비하인드 백 드리블(Behind Back Dribble)", "드리블하고 있는 볼을 몸 뒤쪽으로 넘겨 반대편으로 옮기는 기술"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "사이드 스텝(Side Step)", "풋웍의 일종, 공격수가 드리블로 짧은 거리를 이동할 때 수비수가 한 쪽 발을 공격수의 진행 방향으로 미끄러지듯이 슬라이드 시키면서 공격수를 마크"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "세이프티(Safety)", "수비진의 가장 마지막에 위치하여 상대팀의 속공을 차단하는 사람"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "세컨드 가드(Second Guard)", "보통 슈팅가드가 맡음. 모든 거리의 슛이 요구되며 속공에 능해야 하며 포인트가드가 상대방 수비에 막힐 시 포인트가드를 대신"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "세트 오펜스(Set Offence)", "속공의 반대인 `지공'을 의미하지만 느리게 공격한다는 뜻은 아님. 팀플레이를 통해 수비의 허점을 파고들며 득점 찬스를 노리는 공격법"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "세트플레이(Set Play)", "5명의 선수가 사전에 약속된 패턴으로 공격, 수비하는 방법이다. 주로 포인트가드가 작전지시"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "센터(Center)", "센터는 농구 포지션 중의 하나로 보통 팀에서 가장 키가 큰 선수가 맡음. 센터는 리바운드, 몸싸움, 골밑에서의 볼 배급능력이 요구되며 따라서 신장, 체력, 점프력 등이 좋아야함"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "속공(Fast Break / FB) ", "공격팀이 상대방의 수비가 갖춰지기 전에 빠른 일련의 동작으로 공격하는 것"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "슛 블로킹(Shoot Blocking)", "슛을 시도하는 선수의 볼을 쳐서 떨어뜨려 슛을 저지하는 플레이  단 슛한 선수와 몸이 접촉되면 파울로 기록"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "슛 블록(Block Shot/BS)", "공격수가 슛한 공이 정점에 오르기 전에 수비수가 손으로 차단하는 것"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "스몰 포워드(Small Forward)", "보통 3번이라고 지칭. 내외곽 플레이가 가능한 올라운드 플레이를 요구하는 포지션"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "스위치(Switch)", "대인 방어시 상대의 스크린플레이에 걸렸을 경우 수비수가 마크맨을 동료와 서로 맞바꾸는 것"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "스위프(Sweep)", "압도적인 승리를 뜻함. 점수로나 정신적으로나 상대팀을 완전히 제압했을 때"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "스크린 아웃(Screen Out)", "리바운드에서 상대방보다 먼저 볼을 빼앗기 위한 마크 방법, 박스아웃이라고도 함"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "스크린플레이(Screen Play)", "자기편 선수에게 붙은 수비수를 몸으로 막아 우리편 선수에게 노마크 슛찬스를 만들어 주는 것"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "스탠스(Stance)", "원활한 플레이를 위해서 중심을 낮게한 자세로 수비자세와 볼을 갖고 있는 선수자세의 각기 상황에 따라 스탠스를 달리함"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "스텝 페이킹(Step Faking)", "프리 풋으로 스텝을 밟아 중심을 이동시키면서 수비수를 속이며 돌파하는 기술"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "3초룰(3 Second Violation)", "공격권을 가지고 있는 팀의 선수는 상대편 바스켓에 가까운 프리드로 라인 안에 3초 이상 머물지 못한다는 규칙. 이 룰은 장신 선수가 로포스트에 마냥 서있으면 박진감이 떨어지고 리바운드와 골밑슛을 독점, 게임의 흥미를 반감시킬 우려가 있어 생김. 이를 위반한 경우에는 바이얼레이션으로 상대팀에게 공격권이 넘어감. 3초룰 위반은 주로 골밑 플레이를 펼치는 센터나 포워드 등이 자주 저지르게됨"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "아웃 오브 바운드(Out of Bound)", "사이드와 앤드라인 밖에서 공을 던져 넣는것을 말함"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "아웃넘버(Out Number)", "공격팀의 인원수가 수비팀의 인원수를 상회하는 수적우위인 상태"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "아웃렛패스(Outlet Pass)", "수비 리바운드를 따냄과 동시에 상대 진영을 파고드는 동료에게 길게 던져주는 패스. 속공 전개시 자주 사용하는 패스로 힘과 함께 정확도가 필수적"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "앨리웁(Alley-oop)", "바스켓 근처에서 점프한 공격수가 공중에서 패스를 받아 착지전에 덩크 슛을 터뜨리거나 슛으로 연결하는 동작. 고난이도 기술로 점프력은 물론, 패스하는 선수와 슛을 던지는 선수의 호흡일치가 중요. 덩크슛으로 연결했을 경우 '앨리웁 덩크'라고 함"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "어시스트 (Assist)", "직접 득점과 연결되는 패스. 패스를 받아서 드리블 슛 한 경우도 어시스트로 인정"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "언더 핸드 레이업 슛 (Under Hand Layup Shoot)", "빠른 스피드에서 볼에 손목의 스냅을 걸어 림에 살짝 올려 놓아 슛함"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "에어볼(Air Ball)", "링에도 정확히 맞지 않은 불완전한 슛"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "오버 헤드 패스(Over Head Pass)", "볼을 양손으로 잡은 상태에서 머리위로 들어 올려 팔꿈치와 손목의 스냅을 이용하여 패스를 하는 것"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "오펜스(Offence)", "공격팀 선수들의 총칭, 또는 공격 그 자체를 가리키는 말"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "오피서(Officer)", "심판원. 시합 중에 코트 안에는 주심과 부심 2명이 들어감"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "올코트프레스(All Court Press)", "전면강압수비로 상대팀의 프론트코트에서부터 밀착수비하는 형태"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "와이드오픈(Wide-open)", "노마크 상태에서의 슛 찬스를 말함. 적절한 패싱 게임과 속공 플레이에 의해서만 가능함"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "원 핸드 세트 슛(One Hand Set Shoot)", "모든 슛의 기본으로 팔을 머리 위쪽으로 뻗어 올려 하반신의 힘을 볼에 실으며 슛"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "원 핸드 푸시 패스(One Hand Push Pass)", "몸을 움직이지 않고 팔만으로 하는 패스로 수비수에게 움직임을 노출당하지 않고 패스를 보낼수 있음"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "원핸드 스냅 패스(One Hand Snap Pass)", "손목의 스냅만으로 볼을 밀듯이 팔을 뻗어서 하는 패스"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "인사이드 스크린(Inside Screen)", "수비수를 상대로 팔을 가슴 앞에 엇갈리게 끼고 벽을 만듦으로써 자기편의 공격수를 노마크 상태로 하여 공격을 유리하게 전개시키는 플레이"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "인사이드 턴(Inside Turn)", "수비수 바로 앞에서 몸을 회전하며 빨리 바깥으로 나가서 패스를 받는 플레이"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "인터셉트(Intercept)", "상대방의 패스를 도중에 가로채거나 튕겨내는 것"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "일리걸디펜스(Illegal Deffense)", "부정수비. 수비위주의 플레이로 득점이 떨어지는 '재미없는' 경기를 막기 위해 지역 방어를 금지한 제도. 한마디로 수비는 1대1 대인 방어만 허용된다. 즉 더블팀 수비(2명의 수비수가 볼을 가진 공격수 1명을 수비)는 일시적으로만 가능하다. 자신이 맡고 있는 공격수를 놔두고 더블팀에 참가한 수비수는 곧 자신의 위치로 돌아와야 함. 첫번째 위반시에는 경고가 주어지며, 두번째부터는 위반한 선수에게 테크니컬 파울이 부과됨(공격팀에 자유투 1개와 볼소유권)"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "10 초룰 위반(10 Second Violation )", "공격시 백코트에서 프론트코트로 10초 이내에 넘어가지 못하는 경우"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "5초 룰(5 Second Violation)", "볼을 가진 플레이어는 5초 이내에 패스, 드리블, 슛 중 어느 것을 해야함. 이것은 드로인이나 프리 드로우일 때도 해당됨"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "24초 룰 위반(24 Second Violation)", "공격팀이 24초 내에 슛하여 림을 맞추지 못했을 때"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "자유투(Free Throw)", "자유투 선 뒤에서 누구의 방해도 받지 않고 던지는 슛. 슛 동작에 일어난 파울, 팀 파울이 5개가 넘었을 때 일어난 경우파울을 당한 선수에게 자유투 기회가 주어짐. 단 골인 한번에 1점"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "점프볼(Jump Ball)", "심판이 볼을 토스업하면 양 팀의 플레이어가 서클 안에서 볼을 서로 캐치하려고 경쟁하는 것. 게임을 시작할 때 등에 사용함"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "존 디펜스(Zone Deffense)", "수비수가 골 부근에서 미리 수비할 범위를 정한 상태에서 그 범위만을 수비하는 수비법"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "존 오펜스(Zone Offence)", "지역 방어를 무너뜨리기 위해 빠른 패스로서 존 안에서 컷인을 시도하는 공격법"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "차징(Charging)", "개인 파울의 하나. 무리하게 나아가 상대방 선수와 부딪히는 것"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "체스트 패스(Chest Pass)", "패스의 기본으로 팔꿈치를 끌어 당기지 않고 공을 가슴에서 양손으로 밀어 내듯이 손목에 스냅을 주어 패스하는 것"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "체인지 오브 페이스(Change of Pace)", "공격 속도를 바꾸는 것. 리듬을 바꾼다고도 함. 공격 속도를 바꾸어 수비수를 혼란스럽게 하는 것은 무척 효과적"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "체크(Check)", "공격수의 드리블에 대응하여 허리를 낮추고 양손을 올려 드리블을 멈추게 함"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "컨트롤 드리블(Control Dribble)", "어떠한 팀 작전 시도나 상대팀이 대인 방어 시 방향 전환, 피봇 훼이크, 백드리블 등을 하는 것"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "컴비네이션 디펜스(Combination Deffense)", "공격팀의 움직임에 대응하는 대인 방어를 병용하여 하는 수비"));

        // 리스트뷰에 어댑터 설정
        list.setAdapter(adapter);
 
        // 새로 정의한 리스너로 객체를 만들어 설정
        list.setOnDataSelectionListener(new OnDataSelectionListener() {
            public void onDataSelected(AdapterView parent, View v, int position, long id) {
                IconTextItem curItem = (IconTextItem) adapter.getItem(position);
                String[] curData = curItem.getData();
 
                //Toast.makeText(getApplicationContext(), "Selected : " + curData[0], 2000).show();
                Intent intent = new Intent(Words.this, AnotherActivity.class); 
                intent.putExtra("name",curData[0]);
                intent.putExtra("content",curData[1]);
                startActivity(intent);
            }
        });
 
        // 화면을 리스트뷰 객체로 채움
        setContentView(list, params);
    }
 
    
     
}
