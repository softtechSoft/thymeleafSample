package com.softtech.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.softtech.actionForm.Greeting;

/**
 * 概要：Thymeleaf-form を利用する場合、ビューとコントロールとデータのデータやり取りサンプルです。
 *       参照：https://spring.pleiades.io/guides/gs/handling-form-submission/
 *0.0
 * 作成者：教育@ソフトテク
 * 作成日：2021/３/２
 */
@Controller
public class GreetingController {

	 /*
	  * 概要：画面初期表示にデータ準備
	  *
	  *
	  * 作成者：教育@ソフトテク
	  * 作成日：2021/３/２
	  */
      @GetMapping("/greeting")
      public String greetingForm(Model model) {

    	  // 画面の初期値を設定する
    	  Greeting gt = new Greeting();
    	  gt.setId(123);
    	  gt.setContent("ようこそ、123さん");
    	  model.addAttribute("greeting", gt);

    	  return "greeting";
      }
      /*
 	  * 概要：画面FormをPost時の処理
 	  *
 	  * @param greeting Postされた画面データ。Ｖａｌｉｄａｔｉｏｎチェックする場所
 	  * @param bindingResult Validationチェックエラー時エラーメッセージなど置く場所。
 	  * @param model 他画面へ引き渡すデータ
 	  *
 	  * 作成者：教育@ソフトテク
 	  * 作成日：2021/３/２
 	  * //public String greetingSubmit(@ModelAttribute Greeting greeting, Model model) {
 	  */
	  @PostMapping("/greeting")
	  public String greetingSubmit(@Valid Greeting greeting, BindingResult bindingResult,Model model) {

		  if (bindingResult.hasErrors()) {
				return "greeting";
		  }

		  //画面入力値を取得
		  String ct = greeting.getContent();
		  // データ変更
		  ct = "画面入力は" + ct + "です。";

		  // データ利用
		  // 一般的に、Serviceへ渡す処理する。
		  // 本サンプルは画面へ戻すだけで示す。
		  greeting.setContent(ct);

		  model.addAttribute("greeting", greeting);

		  return "result";
	  }
}
