package cn.javass.themes.smvcsm.actions;

import cn.javass.xgen.genconf.vo.ModuleConfModel;
import cn.javass.xgen.geninvocation.BaseGenAction;
import cn.javass.xgen.geninvocation.decorator.GenComponent;

public class GenVoAction extends BaseGenAction {
	public Object initObject() {
		return "";
	}

	public Object execute(ModuleConfModel moduleConf, Object obj) {
		return obj;
	}

	public Object executeDecorators(ModuleConfModel moduleConf, Object obj,
			GenComponent gc) {
		return gc.operation(moduleConf, "GenVo", obj);
	}

	public GenComponent beforeAction(ModuleConfModel moduleConf) {
		return super.defaultBeforeAction(moduleConf);
	}
}
