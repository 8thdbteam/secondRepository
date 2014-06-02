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
         
        // Ÿ��Ʋ ���ֱ�
        requestWindowFeature(Window.FEATURE_NO_TITLE);
 
        // ����Ʈ�� ��ü ����
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.FILL_PARENT);
        list = new DataListView(this);
 
        // ����� ��ü ����
        adapter = new IconTextListAdapter(this);
 
        // ������ ������ �����
        Resources res = getResources();
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "����(Guard)", " ������ ������ ������ ��Ʈ ���� ���ž, ����� Ű�ʹ� ũ�� ����� ������ �帮��� ��ø���� �־�� �ϸ� ���� �εǰ� ���������� �䱸�Ǵ� ������"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "�Ǿط�(Gun&Run)", "������ �����ϴ� ��, �绡�� ���� ���� �� ������ ƴ�� �����ʰ� �����ϴ� �÷���"));        
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "����Ÿ��(Game Time)", "���ð��� 1���ʹ� 10��, ��40���̸� �������� 5��"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "�� �ٵ�(Goaltending)", "���� ���� �� ���� ���� �� �̰��� �ǵ帮�� ���. �������� �ǵ帮�� ��� ������ �ǰ� �������� �ǵ帮�� ��� ����"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "�ѹ� �÷���(Number Play)", "������ ��ӵ� �÷��̷�, ���ڸ� ���� ������ ������"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "����н�(No Look Pass )", "���� ������� ���̱� ���� �ٸ� ������ ������ä�� �н��ϴ� ������ �÷��̸� ����"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "���� �帮��(Double Dribble)", "�帮���ϴ� ���� ��Ҵٰ� �ٽ� �帮���� ���"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "���� ����Ʈ(Double Post)", "��� ���� 2���� ������ ���󿡼� �ϴ� ����"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "����Ŭ��ġ(Double Clutch)", "���߿� ���� �� ���¿��� �ѹ� �� �����ϴ� ��, �ϴ� ������ ������� ���� ���� �ڿ� ü�� �߿� ���� �پ�ö� �븶ũ ���¸� ����� ��� ���̾����̳� ��ý�Ʈ�� �ϴ� ���"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "������(Double Team)", "���� ���� ���ݼ��� ����� 2���� ������ ��å�� ���߽�Ű�� ������. ����� 3���� �����δ� ����� Ʈ������(Triple Team)�̶�� �θ�"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "�����Ŀ�(Double Foul)", "�� �� ������ ���ÿ� �Ŀ��� ���ϴ� ��. �� ��� �� �������� ���� 1������ �����Ŀ��� ��ϵǸ� ������ �Ӹ� ���� �ָ��� �� ������ X�ڷ� �������Ѹ� �����Ŀ��� ǥ���Ѵ�. �̾� ������ ���ݱ��� ������ ���� �������� �����ϴµ� �̶� �������� �Ŀ��� ���� ���� ���̼� �ϰ� �Ǹ� ���� ����� ��Ŭ���� �ǽ�"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "��ũ��(Dunk Shoot)", "���� �� ������ ���� ���� �ִ� ��"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "�����Ʈ�� (Door Mat Team)", "�¸��� ������ �ȴٴ� �ǹ�, ��������� ���� �¸��� �峳�ϴ� ������ �̸�"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "��¡(Dodging)", "���� ������ �̿�, ���� ������ �ް��� �ٲٸ� ��� ���� ���ذ��� ��"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "�帮��(Dribble)", " ���� �ٴڿ� Ƣ��� ��Ʈ������ �̵��ϴ� ��. �帮���� ���� Ʈ������ �ɸ��� �����Ƿ� ���� ���� ä �̵��ϴ� ���"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "�帮�� ��ƿ(Dribble Steal)", "�����ϰ� ���� ���Ѵ� ������ ���潺�� ������ �帮���ϰ� �ִ� ���� ���� ��"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "���������� �Ŀ�(Disqualfying Foul)", "������ ����ģ, �������ǽʿ� ��߳� �Ŀ�, �� ��� ��� �ǰݵǾ� ������ ���� ���� ����"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "���潺(Defense)", "��� �Ǵ� ����ϴ� �� "));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "���� �帮��(Running Dribble)", "�޸��鼭 �ϴ� �帮��"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "���װ���(Running Game)", "Ʈ�������� ���� �Ӱ������� ����"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "���ַ�����(Regular Season)", "���Խ����� ����.NBA ���ַ������� �ų� 11�� ù�ֳ� ��°�ֿ� ����, ������ 4������ ���� 82������ ġ��.������ ���´� ���۷��� �� �ٸ� ����� ������� Ȩ�� ����� 2���Ӿ��� ġ����, �ٸ� ���۷����� ������� Ȩ�� ����� 1���Ӿ�, ��2������ ġ��.�̸� ����-��(double-one)����̶�� �ϴµ�, �� ������� ���۷����� ���� ���� ������ �־������� ���� ������ ������ 1/2, 1/4�� �������� ����"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "���̾� ��(Lay-up Shoot)", "������ �� �� �ؿ��� ����ڵ�� ������ ��"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "����ο� �帮��(Leg Through Dribble)", "�յڷ� ���� �ٸ� ���̷� ���� ��Ʈ���ϸ� ���� ��ȯ�� �ϴ� ���"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "�ν���(Roster)", " ������� ����� ����. 2���� ���� NBA������ 12���� �ν��Ϳ� ��.�ٸ� �λ��� ����Ʈ���� 3������� ����Ҽ� ����"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "�ο� ����Ʈ(Low Post)", "������ �ص���������� 3�� �̻� �ӹ��� ���� ������ ����"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "�����̼�(Rotation)", "5���� ������� ��ũ�ϴ� ���ݼ��� ���ʷ� �ٲٸ鼭 ���� �������� ���� ���� ��"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "�� ����(Lock Step)", "���潺�� ������ ��ġ�� ���� �н��� �޴� ��"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "�� ���� ��ũ��(Roll Off Screen)", "�÷��̿��� ��ũ���ʰ� ������ �� �ڽ��� ���� �����ϸ鼭 ��������� �޸��� �÷���"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "�� �۶��̵�(Long Glide)", "���ӷ����� �޸��� ���ݼ��� �����ϴ� ����"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "���� ��(Loose Ball)", "��� �����Ե� ���� ���� ���� ��"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "���ٿ��(Rebound)", "���ε��� �ʰ� ���̳� �麸�忡 �¾Ƽ� ƨ�� ���� ���� ĳġ �ϴ� ��"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "����������̼�(Rehabilitation)", "��� �� �λ���� ������ ����óġ�ϴ� ��"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "������(Release)", "�н��� ���� �� �� ���� ���� �� �Ǵ� �� ����"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "������ Ÿ�̹�(Release Time)", "���� ���� ����� ����"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "��ũ(Mark)", "������� �ڽ��� ���� ���ݼ��� �پ �����ϴ� ��. ���潺 üũ��� ��"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "��ġ��(Match Up)", "���ݼ��� ������� 1:1�� �´���ϴ� ��Ȳ �Ǵ� ���� �����ؾ��ϴ� ������ ��Ī, �ַ� ���� �����ǳ��� ��ġ���� �̷����"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "������ ���潺(Man to Man Defense)", " 5���� ������� ���� 1��1�� ��븦 ���� ��. ���� ���"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "�̽���ġ(Mismatch)", "���� ��Ȱ�� ������ �ϱ� ���� ���� �����̼��� ����. ���� ��� �ܰ����� Ű ū ���Ͱ� ���� ���忡�� ���� ������ �� ����� ������ ������ ���� �Ҹ��� ��Ȳ�� ��. �ݴ�� �λ��̵忡�� ����� ���潺�� �ܽ��� ���潺�� ���� ������ ��ؿ����� �ܿ� �������� �������� ���� ���� ���� �� ����"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "�ٽ��� �������̽�(Basket Interface)", "���� ���� �������� �������� ������ ���� ������, �Ǵ� ���� �� ���� �Ƿ� ���� �� ������� ���̳� �麸�忡 ���� ���, ���� ������ ������ ����. �������� �Ȱ��� �÷��̸� �ϴ� ��쿡�� ���� ����� ���̵� ���ο��� ���� ���� ������� ��"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "�ٽ���ī��Ʈ(Basket Count)", "�� ���۽� ����� ������� ��Ģ(�����Ģ)�� ���� ��� �� ���� ���� ������ �����ʰ� ���ÿ� �߰� ������ �ϳ��� �־���"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "�ٿ�� �н�(Bound Pass)", "���� Ƣ�ܼ� �ִ� �н� (����� ����� �̿�)"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "���̾��̼�(Violation)", "`�� ����'�̶� ������ �Ŀ￡ ������ �ʴ� ��Ģ. ���̾��̼��� ������ ��� ���ݱ��� ��������� �Ѿ�� ������ �ش缱�����Դ� �����Ŀ��� ������� ����"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "�ڽ��ƿ�(Box Out)", "���ٿ�带 ���� ������� ����Ʈ�� ������ ��뼱���� �ִ��� �о�� ����"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "�ڽ���(Box One)", "����� ���ͳ� Ư�� ���� 1���� ���߸�ũ�ϰ� �������� ����������¸� ���ϴ� ����"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "�� ����(Back Door)", "���� ���� ���� ���� 2���� ������ �����Ͽ� ��ũ���÷��̸� �����ϸ� 2 �� 1�� ��Ȳ�� ����� ������ �����ϴ� �÷���"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "�� ��(Back Shoot)", "��븦 ���� �븮�� ���� �ƴ϶� �麸�忡 �� �� ���� ������ ���� �ִ� ��"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "�� ��ũ��(Back Screen)", "����Ʈ���� �̿��� ����� ���������� �޸��鼭 ��ũ�� ���¸� ����� �ڽ��� ������� �������� �÷���"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "�� ��(Back Turn)", "�ڽ��� ��ũ�� ���� ������� ������ ȸ���Ͽ� ���̴� ���"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "�� �� �帮��(Back Turn Dribble)", "���Ͽ� �ڷ� ���� ������ ���� ��Ʈ���ϰ� �ִ� ���� �¿� �Ǵ� ���·� �ٲپ� ���� ��ȯ�ϴ� ���"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "���(Back Up)", "���������� ��ġ���� ���� �ִ� ���� ��Ʈ�� ���� ª�� �ð����� �׿����� �����ϴ� �ĺ�����"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "����Ʈ(Back Court)", "������ �ڽŵ��� ��Ű�� ��Ʈ�� ����Ű���� �ĸ��� ��ġ�� �ִ� ������, �� 2���� ���带 ����.����Ʈ�� ���ϴٰ� �ϸ� ������ ������ �����ϴٴ� ��"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "��������(Buzzer Beater)", "���ͺ� ���� ������ �Բ� ������ ������ ��. ������ �︮�� ���� ������ ���� ������ ���� �����־�� ������ �������� �� ����"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "���̽��� �н�(Baseball Pass)", "���� ������ ������ �߱��� �������� �����ϴٰ� �ؼ� �ٿ��� �̸�. ���� �ָ� ������ ���� �� �־� �Ӱ��� ���� ���"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "��ġ���ھ�(Bench Score)", "��Ÿ�ø�� 5���� ������ ������ ��⵵�� ���ԵǴ� ��ü �������� ����� ����Ʈ�� �ջ��� ��. ��ġ���ھ ���� ���� �������� ü�¼Ҹ� ���� �ݸ� ��ġ���ھ ���� ���� ���� ��뿡 ������ �־� ��� ���̽��� ���������� ����"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "���ڵ帵(Ball Handling)", "����Ʈ�Ѵɷ°� ���� ���� ��.���� Ȯ���� ŵ�Ͽ� �ڽ��� ������� �丮�� �� �־�� ��"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "���ŷ ��(Blocking Shoot)", "�������� ���� ���ų� �ĳ��� ������ �����ϴ� �÷���"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "���(Block)", "����� ���� ���߿��� ���߰� �ϰų� �ĳ��� ��"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "�����ε� �� �� �н�(Behind The Back Pass)", "���� �� �ڷ� ������ �ո��� ������ ����Ͽ� �н� �ϴ� ���"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "�����ε� �� �帮��(Behind Back Dribble)", "�帮���ϰ� �ִ� ���� �� �������� �Ѱ� �ݴ������� �ű�� ���"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "���̵� ����(Side Step)", "ǲ���� ����, ���ݼ��� �帮��� ª�� �Ÿ��� �̵��� �� ������� �� �� ���� ���ݼ��� ���� �������� �̲��������� �����̵� ��Ű�鼭 ���ݼ��� ��ũ"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "������Ƽ(Safety)", "�������� ���� �������� ��ġ�Ͽ� ������� �Ӱ��� �����ϴ� ���"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "������ ����(Second Guard)", "���� ���ð��尡 ����. ��� �Ÿ��� ���� �䱸�Ǹ� �Ӱ��� ���ؾ� �ϸ� ����Ʈ���尡 ���� ���� ���� �� ����Ʈ���带 ���"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "��Ʈ ���潺(Set Offence)", "�Ӱ��� �ݴ��� `����'�� �ǹ������� ������ �����Ѵٴ� ���� �ƴ�. ���÷��̸� ���� ������ ������ �İ��� ���� ������ �븮�� ���ݹ�"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "��Ʈ�÷���(Set Play)", "5���� ������ ������ ��ӵ� �������� ����, �����ϴ� ����̴�. �ַ� ����Ʈ���尡 ��������"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "����(Center)", "���ʹ� �� ������ ���� �ϳ��� ���� ������ ���� Ű�� ū ������ ����. ���ʹ� ���ٿ��, ���ο�, ��ؿ����� �� ��޴ɷ��� �䱸�Ǹ� ���� ����, ü��, ������ ���� ���ƾ���"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "�Ӱ�(Fast Break / FB) ", "�������� ������ ���� �������� ���� ���� �Ϸ��� �������� �����ϴ� ��"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "�� ���ŷ(Shoot Blocking)", "���� �õ��ϴ� ������ ���� �ļ� ����߷� ���� �����ϴ� �÷���  �� ���� ������ ���� ���˵Ǹ� �Ŀ�� ���"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "�� ���(Block Shot/BS)", "���ݼ��� ���� ���� ������ ������ ���� ������� ������ �����ϴ� ��"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "���� ������(Small Forward)", "���� 3���̶�� ��Ī. ���ܰ� �÷��̰� ������ �ö��� �÷��̸� �䱸�ϴ� ������"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "����ġ(Switch)", "���� ���� ����� ��ũ���÷��̿� �ɷ��� ��� ������� ��ũ���� ����� ���� �¹ٲٴ� ��"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "������(Sweep)", "�е����� �¸��� ����. �����γ� ���������γ� ������� ������ �������� ��"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "��ũ�� �ƿ�(Screen Out)", "���ٿ�忡�� ���溸�� ���� ���� ���ѱ� ���� ��ũ ���, �ڽ��ƿ��̶�� ��"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "��ũ���÷���(Screen Play)", "�ڱ��� �������� ���� ������� ������ ���� �츮�� �������� �븶ũ �������� ����� �ִ� ��"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "���Ľ�(Stance)", "��Ȱ�� �÷��̸� ���ؼ� �߽��� ������ �ڼ��� �����ڼ��� ���� ���� �ִ� �����ڼ��� ���� ��Ȳ�� ���� ���Ľ��� �޸���"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "���� ����ŷ(Step Faking)", "���� ǲ���� ������ ��� �߽��� �̵���Ű�鼭 ������� ���̸� �����ϴ� ���"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "3�ʷ�(3 Second Violation)", "���ݱ��� ������ �ִ� ���� ������ ����� �ٽ��Ͽ� ����� ������� ���� �ȿ� 3�� �̻� �ӹ��� ���Ѵٴ� ��Ģ. �� ���� ��� ������ ������Ʈ�� ���� �������� �������� �������� ���ٿ��� ��ؽ��� ����, ������ ��̸� �ݰ���ų ����� �־� ����. �̸� ������ ��쿡�� ���̾��̼����� ��������� ���ݱ��� �Ѿ. 3�ʷ� ������ �ַ� ��� �÷��̸� ��ġ�� ���ͳ� ������ ���� ���� �������Ե�"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "�ƿ� ���� �ٿ��(Out of Bound)", "���̵�� �ص���� �ۿ��� ���� ���� �ִ°��� ����"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "�ƿ��ѹ�(Out Number)", "�������� �ο����� �������� �ο����� ��ȸ�ϴ� ���������� ����"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "�ƿ����н�(Outlet Pass)", "���� ���ٿ�带 ������ ���ÿ� ��� ������ �İ��� ���ῡ�� ��� �����ִ� �н�. �Ӱ� ������ ���� ����ϴ� �н��� ���� �Բ� ��Ȯ���� �ʼ���"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "�ٸ���(Alley-oop)", "�ٽ��� ��ó���� ������ ���ݼ��� ���߿��� �н��� �޾� �������� ��ũ ���� �Ͷ߸��ų� ������ �����ϴ� ����. ���̵� ����� �������� ����, �н��ϴ� ������ ���� ������ ������ ȣ����ġ�� �߿�. ��ũ������ �������� ��� '�ٸ��� ��ũ'��� ��"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "��ý�Ʈ (Assist)", "���� ������ ����Ǵ� �н�. �н��� �޾Ƽ� �帮�� �� �� ��쵵 ��ý�Ʈ�� ����"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "��� �ڵ� ���̾� �� (Under Hand Layup Shoot)", "���� ���ǵ忡�� ���� �ո��� ������ �ɾ� ���� ��¦ �÷� ���� ����"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "���(Air Ball)", "������ ��Ȯ�� ���� ���� �ҿ����� ��"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "���� ��� �н�(Over Head Pass)", "���� ������� ���� ���¿��� �Ӹ����� ��� �÷� �Ȳ�ġ�� �ո��� ������ �̿��Ͽ� �н��� �ϴ� ��"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "���潺(Offence)", "������ �������� ��Ī, �Ǵ� ���� �� ��ü�� ����Ű�� ��"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "���Ǽ�(Officer)", "���ǿ�. ���� �߿� ��Ʈ �ȿ��� �ֽɰ� �ν� 2���� ��"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "����Ʈ������(All Court Press)", "���鰭�м���� ������� ����Ʈ��Ʈ�������� ���������ϴ� ����"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "���̵����(Wide-open)", "�븶ũ ���¿����� �� ������ ����. ������ �н� ���Ӱ� �Ӱ� �÷��̿� ���ؼ��� ������"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "�� �ڵ� ��Ʈ ��(One Hand Set Shoot)", "��� ���� �⺻���� ���� �Ӹ� �������� ���� �÷� �Ϲݽ��� ���� ���� ������ ��"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "�� �ڵ� Ǫ�� �н�(One Hand Push Pass)", "���� �������� �ʰ� �ȸ����� �ϴ� �н��� ��������� �������� ��������� �ʰ� �н��� ������ ����"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "���ڵ� ���� �н�(One Hand Snap Pass)", "�ո��� ���������� ���� �е��� ���� ��� �ϴ� �н�"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "�λ��̵� ��ũ��(Inside Screen)", "������� ���� ���� ���� �տ� �������� ���� ���� �������ν� �ڱ����� ���ݼ��� �븶ũ ���·� �Ͽ� ������ �����ϰ� ������Ű�� �÷���"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "�λ��̵� ��(Inside Turn)", "����� �ٷ� �տ��� ���� ȸ���ϸ� ���� �ٱ����� ������ �н��� �޴� �÷���"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "���ͼ�Ʈ(Intercept)", "������ �н��� ���߿� ����ä�ų� ƨ�ܳ��� ��"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "�ϸ��ɵ��潺(Illegal Deffense)", "��������. ���������� �÷��̷� ������ �������� '��̾���' ��⸦ ���� ���� ���� �� ������ ����. �Ѹ���� ����� 1��1 ���� �� ���ȴ�. �� ������ ����(2���� ������� ���� ���� ���ݼ� 1���� ����)�� �Ͻ������θ� �����ϴ�. �ڽ��� �ð� �ִ� ���ݼ��� ���ΰ� �������� ������ ������� �� �ڽ��� ��ġ�� ���ƿ;� ��. ù��° ���ݽÿ��� ��� �־�����, �ι�°���ʹ� ������ �������� ��ũ���� �Ŀ��� �ΰ���(�������� ������ 1���� ��������)"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "10 �ʷ� ����(10 Second Violation )", "���ݽ� ����Ʈ���� ����Ʈ��Ʈ�� 10�� �̳��� �Ѿ�� ���ϴ� ���"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "5�� ��(5 Second Violation)", "���� ���� �÷��̾�� 5�� �̳��� �н�, �帮��, �� �� ��� ���� �ؾ���. �̰��� ������̳� ���� ��ο��� ���� �ش��"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "24�� �� ����(24 Second Violation)", "�������� 24�� ���� ���Ͽ� ���� ������ ������ ��"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "������(Free Throw)", "������ �� �ڿ��� ������ ���ص� ���� �ʰ� ������ ��. �� ���ۿ� �Ͼ �Ŀ�, �� �Ŀ��� 5���� �Ѿ��� �� �Ͼ ����Ŀ��� ���� �������� ������ ��ȸ�� �־���. �� ���� �ѹ��� 1��"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "������(Jump Ball)", "������ ���� �佺���ϸ� �� ���� �÷��̾ ��Ŭ �ȿ��� ���� ���� ĳġ�Ϸ��� �����ϴ� ��. ������ ������ �� � �����"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "�� ���潺(Zone Deffense)", "������� �� �αٿ��� �̸� ������ ������ ���� ���¿��� �� �������� �����ϴ� �����"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "�� ���潺(Zone Offence)", "���� �� ���ʶ߸��� ���� ���� �н��μ� �� �ȿ��� ������ �õ��ϴ� ���ݹ�"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "��¡(Charging)", "���� �Ŀ��� �ϳ�. �����ϰ� ���ư� ���� ������ �ε����� ��"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "ü��Ʈ �н�(Chest Pass)", "�н��� �⺻���� �Ȳ�ġ�� ���� ����� �ʰ� ���� �������� ������� �о� ������ �ո� ������ �־� �н��ϴ� ��"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "ü���� ���� ���̽�(Change of Pace)", "���� �ӵ��� �ٲٴ� ��. ������ �ٲ۴ٰ� ��. ���� �ӵ��� �ٲپ� ������� ȥ�������� �ϴ� ���� ��ô ȿ����"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "üũ(Check)", "���ݼ��� �帮�� �����Ͽ� �㸮�� ���߰� ����� �÷� �帮���� ���߰� ��"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "��Ʈ�� �帮��(Control Dribble)", "��� �� ���� �õ��� ������� ���� ��� �� ���� ��ȯ, �Ǻ� ����ũ, ��帮�� ���� �ϴ� ��"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "�ĺ���̼� ���潺(Combination Deffense)", "�������� �����ӿ� �����ϴ� ���� �� �����Ͽ� �ϴ� ����"));

        // ����Ʈ�信 ����� ����
        list.setAdapter(adapter);
 
        // ���� ������ �����ʷ� ��ü�� ����� ����
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
 
        // ȭ���� ����Ʈ�� ��ü�� ä��
        setContentView(list, params);
    }
 
    
     
}
