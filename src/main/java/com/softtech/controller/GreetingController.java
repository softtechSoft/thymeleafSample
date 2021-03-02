package com.softtech.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.softtech.actionForm.Greeting;

/**
 * 概要：Thymeleaf-form を利用する場合、ビューとコントロールとデータのデータやり取りサンプルです。
 *       参照：https://spring.pleiades.io/guides/gs/handling-form-submission/
 *
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
 	  *
 	  * 作成者：教育@ソフトテク
 	  * 作成日：2021/３/２
 	  */
	  @PostMapping("/greeting")
	  public String greetingSubmit(@ModelAttribute Greeting greeting, Model model) {
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
