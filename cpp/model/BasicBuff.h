#ifndef FANTASYBATTLE_BASIC_BUFF_H
#define FANTASYBATTLE_BASIC_BUFF_H

#include "Buff.h"

class BasicBuff : public Buff {
public:
    BasicBuff(float soakModifier, float damageModifier);

    virtual float getSoakModifier() override;
    virtual float getDamageModifier() override;

protected:
    float soakModifier;
    float damageModifier;
};


#endif //FANTASYBATTLE_BASIC_BUFF_H
